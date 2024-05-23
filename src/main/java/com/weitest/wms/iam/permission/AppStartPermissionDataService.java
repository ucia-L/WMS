package com.weitest.wms.iam.permission;

import com.weitest.wms.config.Constants;
import com.weitest.wms.domain.entities.*;
import com.weitest.wms.domain.enumeration.UserSourceEnumEnum;
import com.weitest.wms.domain.enumeration.UserStatusEnumEnum;
import com.weitest.wms.repository.entities.*;
import com.weitest.wms.repository.entities.LCAPRolePerMappingMapper;
import com.weitest.wms.service.entities.*;
import com.weitest.wms.task.permission.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
* 应用启动时权限数据处理类
*
* @author sys
* @since 3.0
*/
@Service
public class AppStartPermissionDataService {

    private final Logger log = LoggerFactory.getLogger(AppStartPermissionDataService.class);
    public static final String USER_SOURCE_ENUM_PREFIX_FIELD = "FIELD_";


    @Resource
    private LCAPRoleService roleService;

    @Resource
    private LCAPPermissionService permissionService;

    @Resource
    private LCAPResourceService resourceService;

    @Resource
    private LCAPPerResMappingService perResMappingService;

    @Resource
    private LCAPRolePerMappingService rolePerMappingService;

    @Resource
    private LCAPUserService userService;

    @Resource
    private LCAPUserRoleMappingService userRoleMappingService;

    @Resource
    private LCAPRoleMapper roleMapper;

    @Resource
    private LCAPResourceMapper resourceMapper;

    @Resource
    private LCAPRolePerMappingMapper rolePerMappingMapper;

    @Resource
    private LCAPPermissionMapper permissionMapper;

    @Resource
    private LCAPUserRoleMappingMapper userRoleMappingMapper;

    @Resource
    private LCAPPerResMappingMapper perResMappingMapper;

    public void permissionDataProcess(DeployPermissionPack permissionPack) throws Exception {

        // 2. 执行默认权限数据上报逻辑
        // 如果没有扩展实现 就走默认上报权限的逻辑
        defaultUploadPermission(
                permissionPack.getResourceMetaDataCollect(),
                permissionPack.getPermissionMetaDataCollect(),
                permissionPack.getRoleMetaDataCollect(),
                permissionPack.getUserMetaDataCollect(),
                permissionPack.getRoleResourceMetaDataCollect()
        );
    }

    private void defaultUploadPermission(List<DeployResourceMetaData> resourceMetaData,
                                         List<DeployPermissionMetaData> permissionMetaData,
                                         List<DeployRoleMetaData> roleMetaData,
                                         List<DeployUserMetaData> userMetaData,
                                         List<DeployRoleResourceMetaData> roleResourceMetaData) throws Exception {
        Instant now = Instant.now();
        ZonedDateTime nowZonedDateTime = now.atZone(ZoneId.systemDefault());

        // 1.1 处理资源数据
        handleResource(resourceMetaData, nowZonedDateTime);

        // 1.2 处理角色数据
        List<LCAPRole> roleNeedDelete = handleRole(roleMetaData, nowZonedDateTime);
        List<Long> roleDeletedIds = roleNeedDelete.stream().map(LCAPRole::getId).collect(Collectors.toList());

        // 1.3 处理权限数据
        List<Long> permissionDeletedIds = handlePermission(roleNeedDelete, permissionMetaData, nowZonedDateTime);

        // 1.4 处理用户数据
        handleUser(userMetaData, nowZonedDateTime);

        // 2 处理绑定关系数据
        handleBind(resourceMetaData, permissionMetaData, roleMetaData, userMetaData, roleResourceMetaData, roleDeletedIds, permissionDeletedIds);
    }

    private void handleBind(List<DeployResourceMetaData> resourceMetaData,
                            List<DeployPermissionMetaData> permissionMetaData,
                            List<DeployRoleMetaData> roleMetaData,
                            List<DeployUserMetaData> userMetaData,
                            List<DeployRoleResourceMetaData> roleResourceMetaData,
                            List<Long> roleDeletedIds,
                            List<Long> permissionDeletedIds) {
        // 1. 用户角色绑定关系
        // 默认就是admin角色
        // 绑定的是用户表的userid和角色表的id
        handleUserRole(userMetaData, roleDeletedIds);

        // 2. 角色权限绑定关系
        // 角色和权限一一对应，绑定的是角色和权限的id值
        List<LCAPPermission> allPermissionInDB = permissionService.list(null);
        if (CollectionUtils.isEmpty(allPermissionInDB)) {
            log.warn("应用启动时绑定角色和权限数据查询数据库权限数据为空");
            return;
        }
        Map<String, Long> permissionNameIdMap = allPermissionInDB.stream().filter(x -> permissionMetaData.stream().anyMatch(y -> y.getName().equals(x.getName()))).collect(Collectors.toMap(LCAPPermission::getName, LCAPPermission::getId, (v1, v2) -> v1));
        handleRolePer(roleMetaData, permissionNameIdMap, roleDeletedIds);

        // 3. 权限资源绑定关系
        handlePermissionRes(resourceMetaData, permissionNameIdMap, roleResourceMetaData, permissionDeletedIds);
    }

    private void handleUserRole(List<DeployUserMetaData> userMetaData, List<Long> roleDeletedIds) {
        if (CollectionUtils.isEmpty(userMetaData)) {
            log.warn("应用启动时绑定用户和角色关系读取用户数据为空");
            return;
        }
        List<LCAPRole> allRoleInDB = roleService.list(null);
        if (CollectionUtils.isEmpty(allRoleInDB)) {
            log.warn("应用启动时绑定用户和角色关系查询数据库角色为空");
            return;
        }
        Optional<LCAPRole> defaultRoleOpt = allRoleInDB.stream().filter(x -> Constants.DEFAULT_ROLE_NAME.equals(x.getName())).findAny();
        if (!defaultRoleOpt.isPresent()) {
            log.warn("应用启动时绑定用户和角色关系查询{}角色数据为空", Constants.DEFAULT_ROLE_NAME);
            return;
        }
        LCAPRole defaultRole = defaultRoleOpt.get();
        List<LCAPUser> allUserInDB = userService.list(null);
        if (CollectionUtils.isEmpty(allUserInDB)) {
            log.warn("应用启动时绑定用户和角色关系查询用户数据为空");
            return;
        }
        Map<String, String> userIdentifierIdMap = allUserInDB.stream().filter(x -> userMetaData.stream().anyMatch(y -> y.getUserName().equals(x.getUserName()))).collect(Collectors.toMap(x -> x.getUserName() + x.getSource(), LCAPUser::getUserId, (v1, v2) -> v1));
        List<LCAPUserRoleMapping> userRoleMappingToSave = userMetaData.stream().map(x -> {
            LCAPUserRoleMapping userRoleMapping = new LCAPUserRoleMapping();
            userRoleMapping.setRoleId(defaultRole.getId());
            userRoleMapping.setUserId(userIdentifierIdMap.get(x.getUserName() + USER_SOURCE_ENUM_PREFIX_FIELD + x.getSource()));
            userRoleMapping.setUserName(x.getUserName());
            userRoleMapping.setSource(x.getSource());
            return userRoleMapping;
        }).collect(Collectors.toList());

        List<LCAPUserRoleMapping> allUserRoleMappingInDb = userRoleMappingService.list(null);
        if (CollectionUtils.isEmpty(allUserRoleMappingInDb)) {
            userRoleMappingService.batchCreate(userRoleMappingToSave);
            return;
        }

        List<LCAPUserRoleMapping> userRoleNeedCreate = userRoleMappingToSave.stream().filter(x -> allUserRoleMappingInDb.stream().noneMatch(y -> x.getUserId().equals(y.getUserId()) && x.getRoleId().equals(y.getRoleId()))).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(userRoleNeedCreate)) {
            userRoleMappingService.batchCreate(userRoleNeedCreate);
        }

        // 用户绑定了一个已经被删除了的角色 则需要删除此绑定关系
        List<LCAPUserRoleMapping> userRoleNeedDelete = allUserRoleMappingInDb.stream().filter(x -> roleDeletedIds.stream().anyMatch(y -> x.getRoleId().equals(y))).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(userRoleNeedDelete)) {
            log.info("应用启动时权限数据处理 待删除的用户角色关联关系数据有: {}", userRoleNeedDelete.stream().map(x -> "用户id:" + x.getUserId() + "用户名:" + x.getUserName() + "角色id:" + x.getRoleId()).collect(Collectors.toList()));
            userRoleMappingMapper.batchDelete(userRoleNeedDelete.stream().map(LCAPUserRoleMapping::getId).collect(Collectors.toList()));
        }
    }

    private void handleRolePer(List<DeployRoleMetaData> roleMetaData, Map<String, Long> permissionNameIdMap, List<Long> roleDeletedIds) {
        if (CollectionUtils.isEmpty(roleMetaData)) {
            log.warn("应用启动时处理角色与权限绑定关系读取角色数据为空");
            return;
        }
        List<LCAPRole> allRoleInDB = roleService.list(null);
        if (CollectionUtils.isEmpty(allRoleInDB)) {
            log.warn("应用启动时绑定角色和权限数据查询数据库角色数据为空");
            return;
        }

        Map<String, Long> roleNameIdMap = allRoleInDB.stream().filter(x -> !x.getEditable()).filter(x -> roleMetaData.stream().anyMatch(y -> {
            if (StringUtils.isNotBlank(x.getUuid())) {
                return y.getUuid().equals(x.getUuid());
            }
            return y.getName().equals(x.getName());
        })).collect(Collectors.toMap(LCAPRole::getName, LCAPRole::getId, (v1, v2) -> v1));

        List<LCAPRolePerMapping> rolePerMapToSave = roleMetaData.stream().map(x -> {
            LCAPRolePerMapping rolePerMapping = new LCAPRolePerMapping();
            rolePerMapping.setPermissionId(permissionNameIdMap.get(x.getName()));
            rolePerMapping.setRoleId(roleNameIdMap.get(x.getName()));
            return rolePerMapping;
        }).collect(Collectors.toList());

        List<LCAPRolePerMapping> allRolePerMappingInDb = rolePerMappingService.list(null);
        if (CollectionUtils.isEmpty(allRolePerMappingInDb)) {
            rolePerMappingService.batchCreate(rolePerMapToSave);
            return;
        }

        List<LCAPRolePerMapping> rolePermissionNeedCreate = rolePerMapToSave.stream()
                .filter(x -> allRolePerMappingInDb.stream().noneMatch(y -> x.getPermissionId().equals(y.getPermissionId()) && x.getRoleId().equals(y.getRoleId())))
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(rolePermissionNeedCreate)) {
            rolePerMappingService.batchCreate(rolePermissionNeedCreate);
        }

        List<LCAPRolePerMapping> rolePerNeedDelete = allRolePerMappingInDb.stream().filter(x -> roleDeletedIds.stream().anyMatch(y -> x.getRoleId().equals(y))).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(rolePerNeedDelete)) {
            log.info("应用发布时权限数据处理 删除如下角色权限关联数据: {}", rolePerNeedDelete.stream().map(x -> "角色id:" + x.getRoleId() + "权限id:" + x.getPermissionId()).collect(Collectors.toList()));
            rolePerMappingMapper.batchDelete(rolePerNeedDelete.stream().map(LCAPRolePerMapping::getId).collect(Collectors.toList()));
        }
    }

    private void handlePermissionRes(List<DeployResourceMetaData> resourceMetaData,
                                     Map<String, Long> permissionNameIdMap,
                                     List<DeployRoleResourceMetaData> roleResourceMetaData,
                                     List<Long> permissionDeletedIds) {

        if (CollectionUtils.isEmpty(roleResourceMetaData)) {
            log.warn("应用启动时读取到角色资源关联关系数据为空");
            return;
        }
        List<LCAPResource> allResourceInDb = resourceService.list(null);
        Map<String, Long> resourceNameIdMap = allResourceInDb.stream().filter(x -> resourceMetaData.stream().anyMatch(y -> y.getName().equals(x.getName()))).collect(Collectors.toMap(LCAPResource::getName, LCAPResource::getId, (v1, v2) -> v1));
        List<LCAPPerResMapping> permissionResToSave = roleResourceMetaData.stream().map(x -> {
            LCAPPerResMapping perResMapping = new LCAPPerResMapping();
            perResMapping.setPermissionId(permissionNameIdMap.get(x.getRoleName()));
            perResMapping.setResourceId(resourceNameIdMap.get(x.getResourcePath()));
            return perResMapping;
        }).collect(Collectors.toList());

        List<LCAPPerResMapping> allPerResMappingInDb = perResMappingService.list(null);
        if (CollectionUtils.isEmpty(allPerResMappingInDb)) {
            perResMappingService.batchCreate(permissionResToSave);
            return;
        }

        List<LCAPPerResMapping> permissionResNeedCreate = permissionResToSave.stream()
                .filter(x -> allPerResMappingInDb.stream().noneMatch(y -> x.getPermissionId().equals(y.getPermissionId()) && x.getResourceId().equals(y.getResourceId())))
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(permissionResNeedCreate)) {
            perResMappingService.batchCreate(permissionResNeedCreate);
        }


        List<LCAPRole> allRoleInDB = roleService.list(null);
        List<LCAPRolePerMapping> allRolePerMapInDB = rolePerMappingService.list(null);
        List<Long> ideRoleIds = allRoleInDB.stream().filter(role -> !role.getEditable()).map(LCAPRole::getId).collect(Collectors.toList());
        List<Long> idePermissions = allRolePerMapInDB.stream().filter(rolePerMapping -> ideRoleIds.contains(rolePerMapping.getRoleId())).map(LCAPRolePerMapping::getPermissionId).collect(Collectors.toList());
        Map<Long, List<LCAPPerResMapping>> idePermissionResMap = permissionResToSave.stream().collect(Collectors.groupingBy(LCAPPerResMapping::getPermissionId));
        Map<Long, List<LCAPPerResMapping>> runtimePermissionResMap = allPerResMappingInDb.stream().collect(Collectors.groupingBy(LCAPPerResMapping::getPermissionId));
        List<Long> runPerResMapNeedDeleteIds = new ArrayList<>();
        runtimePermissionResMap.forEach((runPerId, runPerResMapList) -> {
            if (idePermissionResMap.containsKey(runPerId)) {
                // 同一个权限关联的资源数据
                List<LCAPPerResMapping> idePerResMaps = idePermissionResMap.get(runPerId);
                List<Long> runPerResMapNeedDeleteIdsTmp = runPerResMapList.stream().filter(runPerRes -> idePerResMaps.stream().noneMatch(idePerRes -> idePerRes.getResourceId().equals(runPerRes.getResourceId()))).map(LCAPPerResMapping::getId).collect(Collectors.toList());
                runPerResMapNeedDeleteIds.addAll(runPerResMapNeedDeleteIdsTmp);
            } else {
               if (idePermissions.contains(runPerId)) {
                   List<Long> runPerResMapNeedDeleteIdsTmp = allPerResMappingInDb.stream().filter(perRes -> perRes.getPermissionId().equals(runPerId)).map(LCAPPerResMapping::getId).collect(Collectors.toList());
                   runPerResMapNeedDeleteIds.addAll(runPerResMapNeedDeleteIdsTmp);
               }
            }
        });
        if (!CollectionUtils.isEmpty(runPerResMapNeedDeleteIds)) {
            List<Long> ids = runPerResMapNeedDeleteIds.stream().distinct().collect(Collectors.toList());
            log.info("应用启动时权限数据处理 检测到权限关联资源数据变动 需要删除的权限和资源关联关系数据有: {}", ids);
            perResMappingMapper.batchDelete(ids);
        }

        List<LCAPPerResMapping> permissionResourceNeedDelete = allPerResMappingInDb.stream().filter(x -> permissionDeletedIds.stream().anyMatch(y -> x.getPermissionId().equals(y))).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(permissionResourceNeedDelete)) {
            log.info("应用启动时权限数据处理 需要删除的权限和资源关联关系数据有: {}", permissionResourceNeedDelete.stream().map(x -> "权限id:" + x.getPermissionId() + "资源id:" + x.getResourceId()).collect(Collectors.toList()));
            perResMappingMapper.batchDelete(permissionResourceNeedDelete.stream().map(LCAPPerResMapping::getId).collect(Collectors.toList()));
        }
    }



    private void handleUser(List<DeployUserMetaData> userMetaData, ZonedDateTime nowZonedDateTime) {
        if (CollectionUtils.isEmpty(userMetaData)) {
            log.warn("应用用户上报列表为空");
            return;
        }

        List<LCAPUser> userDataToSave = userMetaData.stream().map(buildUserEntityFunc(nowZonedDateTime)).collect(Collectors.toList());
        List<LCAPUser> allUserInDb = userService.list(null);
        if (CollectionUtils.isEmpty(allUserInDb)) {
            userService.batchCreate(userDataToSave);
            return;
        }

        userDataToSave = userMetaData.stream().filter(x -> allUserInDb.stream().noneMatch(y -> y.getUserId().equals(x.getUserId()))).map(buildUserEntityFunc(nowZonedDateTime)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(userDataToSave)) {
            userService.batchCreate(userDataToSave);
        }
    }

    private static Function<DeployUserMetaData, LCAPUser> buildUserEntityFunc(ZonedDateTime nowZonedDateTime) {
        return x -> {
            LCAPUser user = new LCAPUser();
            user.setUserId(x.getUserId());
            user.setPassword(x.getPassword());
            user.setDisplayName(x.getDisplayName());
            user.setUserName(x.getUserName());
            user.setCreatedTime(nowZonedDateTime);
            user.setSource(UserSourceEnumEnum.valueOf(USER_SOURCE_ENUM_PREFIX_FIELD + x.getSource()));
            user.setStatus(UserStatusEnumEnum.valueOf(USER_SOURCE_ENUM_PREFIX_FIELD + x.getStatus()));
            return user;
        };
    }

    private List<Long> handlePermission(List<LCAPRole> roleNeedDelete, List<DeployPermissionMetaData> permissionMetaData, ZonedDateTime nowZonedDateTime) {
        List<Long> permissionNeedDeleteIds = new ArrayList<>();
        if (CollectionUtils.isEmpty(permissionMetaData)) {
            log.warn("应用权限上报列表为空");
            return permissionNeedDeleteIds;
        }
        List<LCAPPermission> permissionToSave = permissionMetaData.stream().map(buildPermissionEntityFunc(nowZonedDateTime)).collect(Collectors.toList());
        // 权限数据和角色数据一一对应，所以删除时 只能删除编辑期的角色
        List<LCAPPermission> allPermissionInDB = permissionService.list(null);
        if (CollectionUtils.isEmpty(allPermissionInDB)) {
            permissionService.batchCreate(permissionToSave);
            return permissionNeedDeleteIds;
        }

        List<LCAPPermission> permissionNeedCreate = permissionMetaData.stream()
                .filter(x -> allPermissionInDB.stream().noneMatch(y -> x.getName().equals(y.getName())))
                .map(buildPermissionEntityFunc(nowZonedDateTime))
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(permissionNeedCreate)) {
            permissionService.batchCreate(permissionNeedCreate);
        }

        // 因为角色数据已经处理好 所以需要删除权限中存在 但是角色中不存在的数据
        List<LCAPRole> allRoleInDb = roleService.list(null);
        List<LCAPPermission> permissionNeedToDelete = allPermissionInDB.stream().filter(x -> roleNeedDelete.stream().anyMatch(y -> y.getName().equals(x.getName()))).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(permissionNeedToDelete)) {
            log.info("应用启动时处理权限数据 删除的权限数据有: {}", permissionNeedToDelete.stream().map(LCAPPermission::getName).collect(Collectors.toList()));
            permissionNeedDeleteIds = permissionNeedToDelete.stream().map(LCAPPermission::getId).collect(Collectors.toList());
            permissionMapper.batchDelete(permissionNeedDeleteIds);
        }
        return permissionNeedDeleteIds;
    }

    private static Function<DeployPermissionMetaData, LCAPPermission> buildPermissionEntityFunc(ZonedDateTime nowZonedDateTime) {
        return x -> {
            LCAPPermission permission = new LCAPPermission();
            permission.setName(x.getName());
            permission.setDescription(x.getDescription());
            permission.setCreatedTime(nowZonedDateTime);
            return permission;
        };
    }

    private List<LCAPRole> handleRole(List<DeployRoleMetaData> roleMetaData, ZonedDateTime nowZonedDateTime) {
        List<LCAPRole> roleNeedDelete = new ArrayList<>();
        if (CollectionUtils.isEmpty(roleMetaData)) {
            log.warn("应用启动时读取的角色上报数据为空");
            return roleNeedDelete;
        }

        List<LCAPRole> rolesToSave = roleMetaData.stream().map(buildRoleEntityFunc(nowZonedDateTime)).collect(Collectors.toList());

        List<LCAPRole> allOldRoleInDb = roleService.list(null);
        if (CollectionUtils.isEmpty(allOldRoleInDb)) {
            roleService.batchCreate(rolesToSave);
            return roleNeedDelete;
        }

        // 是否存在编辑期与运行期同名角色
        Optional<LCAPRole> ideRoleRunRoleSameNameOpt = allOldRoleInDb.stream().filter(LCAPRole::getEditable).filter(runRole -> roleMetaData.stream().anyMatch(ideRole -> ideRole.getName().equals(runRole.getName()))).findAny();
        if (ideRoleRunRoleSameNameOpt.isPresent()) {
              throw new RuntimeException("运行期角色和编辑期角色同名: " + ideRoleRunRoleSameNameOpt.get().getName());
        }

        List<LCAPRole> ideRolesInDb = allOldRoleInDb.stream().filter(x -> !x.getEditable()).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(ideRolesInDb)) {
            roleService.batchCreate(rolesToSave);
            return roleNeedDelete;
        }

        // 更新IDE角色名称
        handleRoleIfNeedCreateOrUpdate(ideRolesInDb,roleMetaData, nowZonedDateTime);

        roleNeedDelete = ideRolesInDb.stream().filter(x -> roleMetaData.stream().noneMatch(y -> {
            if (StringUtils.isNotBlank(x.getUuid())) {
               return y.getUuid().equals(x.getUuid());
            }
            return y.getName().equals(x.getName());
        })).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(roleNeedDelete)) {
            log.info("应用发布时处理权限数据 删除如下角色: {}", roleNeedDelete.stream().map(x -> "角色名称:" + x.getName() + " uuid:" + x.getUuid()).collect(Collectors.toList()));
            List<Long> roleNeedDeleteIds = roleNeedDelete.stream().map(LCAPRole::getId).collect(Collectors.toList());
            roleMapper.batchDelete(roleNeedDeleteIds);
        }
        return roleNeedDelete;
    }

    private void handleRoleIfNeedCreateOrUpdate(List<LCAPRole> ideRolesInDb, List<DeployRoleMetaData> roleMetaData, ZonedDateTime nowZonedDateTime) {
        // 更新IDE角色名称
        List<LCAPRole> roleNameNeedUpdate = new ArrayList<>();
        for (LCAPRole lcapRole : ideRolesInDb) {
            Optional<DeployRoleMetaData> any = roleMetaData.stream().filter(x -> x.getUuid().equals(lcapRole.getUuid()) && !x.getName().equals(lcapRole.getName())).findAny();
            if (any.isPresent()) {
                DeployRoleMetaData deployRoleMetaData = any.get();
                lcapRole.setName(deployRoleMetaData.getName());
                roleNameNeedUpdate.add(lcapRole);
             }
        }
        if (!CollectionUtils.isEmpty(roleNameNeedUpdate)) {
            roleService.batchUpdate(roleNameNeedUpdate, Collections.singletonList("name"));
        }
        //创建IDE新的角色
        List<LCAPRole> roleNeedCreate = roleMetaData.stream().filter(x -> ideRolesInDb.stream().noneMatch(y -> {
            if (StringUtils.isNotBlank(y.getUuid())) {
                 return y.getUuid().equals(x.getUuid());
             }
             return y.getName().equals(x.getName());
        })).map(buildRoleEntityFunc(nowZonedDateTime)).collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(roleNeedCreate)) {
            roleService.batchCreate(roleNeedCreate);
        }
    }

    private static Function<DeployRoleMetaData, LCAPRole> buildRoleEntityFunc(ZonedDateTime nowZonedDateTime) {
        return x -> {
            LCAPRole role = new LCAPRole();
            role.setUuid(x.getUuid());
            role.setName(x.getName());
            role.setDescription(x.getDescription());
            role.setCreatedTime(nowZonedDateTime);
            role.setEditable(Boolean.valueOf(x.getEditable()));
            role.setRoleStatus(Boolean.valueOf(x.getRoleStatus()));
            return role;
        };
    }

    private void handleResource(List<DeployResourceMetaData> resourceMetaData, ZonedDateTime nowZonedDateTime) {
        if (CollectionUtils.isEmpty(resourceMetaData)) {
            log.warn("应用启动时读取到的资源上报列表为空");
            return;
        }

        List<LCAPResource> resourceDataToSave = resourceMetaData.stream().map(buildResourceEntityFunc(nowZonedDateTime)).collect(Collectors.toList());
        // 资源数据无法在运行期新增，所以数据全部依赖于编辑期发布时的资源数据
        List<LCAPResource> oldList = resourceService.list(null);
        if (CollectionUtils.isEmpty(oldList)) {
            resourceService.batchCreate(resourceDataToSave);
            return;
        }

        List<LCAPResource> resourcesNeedCreate = resourceMetaData.stream().filter(x -> oldList.stream().noneMatch(y -> y.getName().equals(x.getName()))).map(buildResourceEntityFunc(nowZonedDateTime)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(resourcesNeedCreate)) {
            resourceService.batchCreate(resourcesNeedCreate);
        }
        List<LCAPResource> resourcesNeedUpdate = new ArrayList<>();
        //是否需要更新介绍
        oldList.forEach(updatedResource -> {
                DeployResourceMetaData updatedDescriptionResourceMetaData = resourceMetaData.stream()
                    .filter(metaData -> (metaData.getName().equals(updatedResource.getName()) && !StringUtils.equals(metaData.getDescription(),updatedResource.getDescription())))
                    .findFirst()
                    .orElse(null);
            if (updatedDescriptionResourceMetaData != null) {
                updatedResource.setDescription(updatedDescriptionResourceMetaData.getDescription());
                resourcesNeedUpdate.add(updatedResource);
            }
        });
        if (!CollectionUtils.isEmpty(resourcesNeedUpdate)) {
             resourceService.batchUpdate(resourcesNeedUpdate,Collections.singletonList("description"));
        }
        List<LCAPResource> resourceNeedDelete = oldList.stream().filter(x -> resourceMetaData.stream().noneMatch(y -> x.getName().equals(y.getName()))).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(resourceNeedDelete)) {
            log.info("应用发布时处理权限数据 删除如下资源数据: {}", resourceNeedDelete.stream().map(x -> "资源名称:" + x.getName() + "端标识:" + x.getClientType()).collect(Collectors.toList()));
            resourceMapper.batchDelete(resourceNeedDelete.stream().map(LCAPResource::getId).collect(Collectors.toList()));
        }
    }

    private static Function<DeployResourceMetaData, LCAPResource> buildResourceEntityFunc(ZonedDateTime nowZonedDateTime) {
        return x -> {
            LCAPResource resource = new LCAPResource();
            resource.setName(x.getName());
            resource.setDescription(x.getDescription());
            // 前端在判断页面有没有权限访问的时候固定写死了ui，所以这边也需要指定为ui
            // 在task2633165763707136会进行修复，修复的时候可以把"ui"改为x.getType()
            resource.setType("ui");
            resource.setCreatedTime(nowZonedDateTime);
            resource.setClientType(x.getClientType());
            return resource;
        };
    }
}
