package com.weitest.wms.service.entities.inner;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import java.beans.PropertyDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.weitest.wms.datasource.dynamic.DataSource;
import com.weitest.wms.exception.HttpCodeException;
import com.weitest.wms.domain.*;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.repository.*;
import com.weitest.wms.util.SpringUtils;
import com.weitest.wms.exception.HttpCodeException;

/**
* auto generate RelationInnerService
*
* @author sys
*/
@Service
public class RelationInnerService {
    private Map<String, List<Object[]>> relationMap = new HashMap<>();
    private static Logger LOGGER = LoggerFactory.getLogger(RelationInnerService.class);
    private static final int INDEX_BEREF_PROPERTY = 0;
    private static final int INDEX_REF_ENTITY_MAPPER_CLASS = 1;
    private static final int INDEX_REF_PROPERTY = 2;
    private static final int INDEX_DEL_RULE = 3;

    public RelationInnerService() {
        relationMap.put("AfterSalesOrderEntity", new ArrayList<>());
        relationMap.get("AfterSalesOrderEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.AfterSaleGoodEntityMapper.class,
            "after_sale_id",
            "protect"
            });
        relationMap.put("OrdersEntity", new ArrayList<>());
        relationMap.get("OrdersEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.InBoundGoodEntityMapper.class,
            "inbound_order_id",
            "protect"
            });
        relationMap.get("OrdersEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.GoodsEntityMapper.class,
            "order_id",
            "cascade"
            });
        relationMap.put("WarehouseEntity", new ArrayList<>());
        relationMap.get("WarehouseEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.IventoryGWASEntityMapper.class,
            "wid",
            "protect"
            });
        relationMap.get("WarehouseEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.AllotOutboundEntityMapper.class,
            "warehouse_Oid",
            "protect"
            });
        relationMap.get("WarehouseEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.AllotOutboundEntityMapper.class,
            "warehouse_Tid",
            "protect"
            });
        relationMap.get("WarehouseEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.WarehouseAreaEntityMapper.class,
            "warehouse_id",
            "protect"
            });
        relationMap.get("WarehouseEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.UserinfoEntityMapper.class,
            "warehouse_id",
            "protect"
            });
        relationMap.put("LCAPUser", new ArrayList<>());
        relationMap.get("LCAPUser").add(new Object[]{
            "userId",
            com.weitest.wms.repository.entities.LCAPUserRoleMappingMapper.class,
            "userId",
            "cascade"
            });
        relationMap.put("ShelfEntity", new ArrayList<>());
        relationMap.get("ShelfEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.IventoryGWASEntityMapper.class,
            "sid",
            "protect"
            });
        relationMap.get("ShelfEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.AllotOutboundEntityMapper.class,
            "shelf_Oid",
            "protect"
            });
        relationMap.get("ShelfEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.AllotOutboundEntityMapper.class,
            "shelf_Tid",
            "protect"
            });
        relationMap.get("ShelfEntity").add(new Object[]{
            "warehouseArea_id",
            com.weitest.wms.repository.entities.WarehouseAreaEntityMapper.class,
            "id",
            "protect"
            });
        relationMap.get("ShelfEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.GoodsEntityMapper.class,
            "shelf_id",
            "cascade"
            });
        relationMap.put("LCAPRole", new ArrayList<>());
        relationMap.get("LCAPRole").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.LCAPRolePerMappingMapper.class,
            "roleId",
            "cascade"
            });
        relationMap.get("LCAPRole").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.LCAPUserRoleMappingMapper.class,
            "roleId",
            "cascade"
            });
        relationMap.put("OutboundOrderEntity", new ArrayList<>());
        relationMap.get("OutboundOrderEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.OutBoundInspectionEntityMapper.class,
            "orderID",
            "cascade"
            });
        relationMap.get("OutboundOrderEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.PackagedEntityMapper.class,
            "outBoundOrderID",
            "cascade"
            });
        relationMap.get("OutboundOrderEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.ShippingEntityMapper.class,
            "outBoundOrderID",
            "cascade"
            });
        relationMap.get("OutboundOrderEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.OutBoundWeighingEntityMapper.class,
            "orderID",
            "cascade"
            });
        relationMap.get("OutboundOrderEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.OutboundPackingEntityMapper.class,
            "outBoundOrderID",
            "protect"
            });
        relationMap.get("OutboundOrderEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.OutBoundGoodEntityMapper.class,
            "outbound_order_id",
            "cascade"
            });
        relationMap.put("WarehouseAreaEntity", new ArrayList<>());
        relationMap.get("WarehouseAreaEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.IventoryGWASEntityMapper.class,
            "waid",
            "protect"
            });
        relationMap.get("WarehouseAreaEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.AllotOutboundEntityMapper.class,
            "warehouseArea_Oid",
            "protect"
            });
        relationMap.get("WarehouseAreaEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.AllotOutboundEntityMapper.class,
            "warehouseArea_Tid",
            "protect"
            });
        relationMap.get("WarehouseAreaEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.GoodsEntityMapper.class,
            "inbound_tmp_area",
            "protect"
            });
        relationMap.get("WarehouseAreaEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.GoodsEntityMapper.class,
            "storage_area_id",
            "cascade"
            });
        relationMap.put("OutboundPackingEntity", new ArrayList<>());
        relationMap.get("OutboundPackingEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.OutBoundSecSortingEntityMapper.class,
            "packingID",
            "cascade"
            });
        relationMap.get("OutboundPackingEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.OutBoundSortingEntityMapper.class,
            "packingID",
            "cascade"
            });
        relationMap.put("LCAPResource", new ArrayList<>());
        relationMap.get("LCAPResource").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.LCAPPerResMappingMapper.class,
            "resourceId",
            "cascade"
            });
        relationMap.put("CommodityEntity", new ArrayList<>());
        relationMap.get("CommodityEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.OutboundPackingEntityMapper.class,
            "outbound_good_id",
            "cascade"
            });
        relationMap.put("UserinfoEntity", new ArrayList<>());
        relationMap.get("UserinfoEntity").add(new Object[]{
            "warehouse_id",
            com.weitest.wms.repository.entities.WarehouseEntityMapper.class,
            "id",
            "protect"
            });
        relationMap.get("UserinfoEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.ApplicationEntityMapper.class,
            "userId",
            "protect"
            });
        relationMap.put("LCAPPermission", new ArrayList<>());
        relationMap.get("LCAPPermission").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.LCAPRolePerMappingMapper.class,
            "permissionId",
            "cascade"
            });
        relationMap.get("LCAPPermission").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.LCAPPerResMappingMapper.class,
            "permissionId",
            "cascade"
            });
        relationMap.put("OutBoundGoodEntity", new ArrayList<>());
        relationMap.get("OutBoundGoodEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.OutBoundInspectionEntityMapper.class,
            "outBoundGoodID",
            "protect"
            });
        relationMap.get("OutBoundGoodEntity").add(new Object[]{
            "id",
            com.weitest.wms.repository.entities.OutBoundWeighingEntityMapper.class,
            "outBoundGoodID",
            "protect"
            });
    }

    @Transactional(rollbackFor = Exception.class)
    public void onDelete(Object entity) {
        try {
            if (relationMap.containsKey(entity.getClass().getSimpleName())) {
                for (Object[] relationPayload : relationMap.get(entity.getClass().getSimpleName())) {
                    String beRefProperty = (String)relationPayload[INDEX_BEREF_PROPERTY];
                    PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(entity.getClass(), beRefProperty);
                    Object propertyVal = propertyDescriptor.getReadMethod().invoke(entity);

                    Class<ReferenceHandleMapper> refEntityMapperClass = (Class<ReferenceHandleMapper>) relationPayload[INDEX_REF_ENTITY_MAPPER_CLASS];
                    String refProperty = (String)relationPayload[INDEX_REF_PROPERTY];
                    ReferenceHandleMapper refEntityMapper = SpringUtils.getBean(refEntityMapperClass);

                    String delRule = (String) relationPayload[INDEX_DEL_RULE];
                    if ("cascade".equals(delRule)) {
                        LOGGER.info("cascade delete entity: {}, property {} = {}",
                            entity.getClass().getSimpleName(), refProperty, propertyVal);
                        refEntityMapper.deleteReference(refProperty, propertyVal);
                    } else if ("protect".equals(delRule)) {
                        Long affect = refEntityMapper.existReference(refProperty, propertyVal);
                        if (affect != null && affect > 0) {
                            throw new HttpCodeException(400, ErrorCodeEnum.RELATION_PROTECT.code);
                        }
                    }
                }
            }
        } catch (HttpCodeException ex) {
            throw ex;
        } catch(Exception e) {
            throw new HttpCodeException(400, "error: " + e.getMessage());
        }
    }
}