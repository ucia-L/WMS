/* 实体表 */
CREATE TABLE `ShelfPreference` (
`id` bigint(20) NOT NULL COMMENT '主键',
`name` varchar(256) NULL COMMENT '偏好名称',
PRIMARY KEY (`id`)
) COMMENT='货架的偏好';


CREATE TABLE `WarehouseAccount` (
`id` bigint(20) NOT NULL COMMENT '主键',
`idTag` varchar(256) NULL COMMENT '账目编号',
`balance` decimal(31,2) NULL COMMENT '收支',
`note` varchar(4000) NULL COMMENT '备注',
`warehouseId` bigint(20) NULL COMMENT '仓库编号',
`category` varchar(256) NULL COMMENT '账目类型',
`createdTime` datetime NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) COMMENT='账目';


CREATE TABLE `Commodity` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`name` varchar(256) NULL COMMENT '商品名称',
`storageUpperLimit` bigint(20) NULL COMMENT '存储上限',
`storageLowerLimit` bigint(20) NULL COMMENT '存储下限',
`inboundPrice` decimal(31,2) NULL COMMENT '入库价格',
`outboundPrice` decimal(31,2) NULL COMMENT '出库价格',
`quantity` bigint(20) NULL COMMENT '商品数量',
`note` varchar(4000) NULL COMMENT '备注',
`unit` varchar(256) NULL COMMENT '单位',
`imgUrl` varchar(4000) NULL COMMENT '图片',
`updatedTime` datetime NULL COMMENT '更新时间',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`warehouseId` bigint(20) NULL COMMENT '仓库id',
PRIMARY KEY (`id`)
) COMMENT='仓内商品表';


CREATE TABLE `OrderOutboundGoods` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`goodId` bigint(20) NULL COMMENT '货物编号',
`name` varchar(256) NULL COMMENT '货物名称',
`unit` varchar(256) NULL COMMENT '货物单位',
`outboundCount` bigint(20) NULL COMMENT '出库数量',
`outboundDate` datetime NULL COMMENT '出库时间',
`warehouseName` varchar(256) NULL COMMENT '仓库名',
`warehouseareaName` varchar(256) NULL COMMENT '货区名',
`shelfName` varchar(256) NULL COMMENT '货架名',
`orderId` bigint(20) NULL COMMENT '售后订单编号',
PRIMARY KEY (`id`)
);


CREATE TABLE `IventoryGWAS` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`gid` bigint(20) NULL COMMENT '货物id',
`gName` varchar(256) NULL COMMENT '货物名',
`gQuantity` bigint(20) NULL COMMENT '货物数量',
`gUnit` varchar(256) NULL COMMENT '货物单位',
`wid` bigint(20) NULL COMMENT '仓库id',
`wName` varchar(256) NULL COMMENT '仓库名',
`waid` bigint(20) NULL COMMENT '库区id',
`waName` varchar(256) NULL COMMENT '货区名',
`sid` bigint(20) NULL COMMENT '货架id',
`sName` varchar(256) NULL COMMENT '货架名',
`dateTime` date NULL COMMENT '日期',
PRIMARY KEY (`id`)
);


CREATE TABLE `OtherInoundGood` (
`id` bigint(20) NOT NULL COMMENT '主键',
`idTag` varchar(256) NULL COMMENT '货物编号',
`name` varchar(256) NULL COMMENT '货物名称',
`inboundPrice` decimal(31,2) NULL COMMENT '入库价格',
`inboundOp` varchar(256) NULL COMMENT '入库操作者',
`note` varchar(256) NULL COMMENT '备注',
`quantity` bigint(20) NULL COMMENT '数量',
`unit` varchar(256) NULL COMMENT '单位',
`status` varchar(256) NULL COMMENT '状态',
`inboundTime` datetime NULL COMMENT '入库时间',
`refuseReason` varchar(256) NULL COMMENT '拒绝原因',
`goodCategory` varchar(256) NULL COMMENT '货物类型',
PRIMARY KEY (`id`)
);


CREATE TABLE `Messagee` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '时间',
`text` varchar(4000) NULL COMMENT '内容',
`sender` varchar(256) NULL COMMENT '发送人',
`status` varchar(256) NULL COMMENT '状态',
`category` varchar(256) NULL COMMENT '类别',
`subject` varchar(256) NULL COMMENT '主题',
PRIMARY KEY (`id`)
);


CREATE TABLE `InventoryGood` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` varchar(256) NULL COMMENT '名称',
`warehouseId` bigint(20) NULL COMMENT '仓库编号',
`warehouseAreaId` bigint(20) NULL COMMENT '库区编号',
`shelfId` bigint(20) NULL COMMENT '货架编号',
`quantity` bigint(20) NULL COMMENT '货物数量',
`realQuantity` bigint(20) NULL COMMENT '真实数量',
`incomeLoss` decimal(31,2) NULL COMMENT '收入或支出',
`taskId` bigint(20) NULL COMMENT '作业编号',
`goodId` bigint(20) NULL COMMENT '货物编号',
`unit` varchar(256) NULL COMMENT '单位',
`wName` varchar(256) NULL COMMENT '仓库名',
`waName` varchar(256) NULL COMMENT '库区名',
`sName` varchar(256) NULL COMMENT '货架名',
`price` decimal(31,2) NULL COMMENT '单价',
PRIMARY KEY (`id`)
);


CREATE TABLE `InventoryTask` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`idTag` varchar(256) NULL COMMENT '任务编号',
`status` varchar(256) NULL COMMENT '状态',
PRIMARY KEY (`id`)
);


CREATE TABLE `AllotOutbound` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` varchar(256) NULL COMMENT '货物名称',
`unit` varchar(256) NULL COMMENT '货物单位',
`quantity` bigint(20) NULL COMMENT '出库数量',
`warehouseOid` bigint(20) NULL COMMENT '原仓库',
`warehouseTid` bigint(20) NULL COMMENT '目的仓库',
`warehouseAreaOid` bigint(20) NULL COMMENT '原货区',
`warehouseAreaTid` bigint(20) NULL COMMENT '目的货区',
`shelfOid` bigint(20) NULL COMMENT '原架位id',
`shelfTid` bigint(20) NULL COMMENT '目的架位id',
`allotTime` datetime NULL COMMENT '调拨时间',
PRIMARY KEY (`id`)
);


CREATE TABLE `OutBoundInspection` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`orderID` bigint(20) NULL COMMENT '出库订单编号',
`outBoundGoodID` bigint(20) NULL COMMENT '货物编号',
`inspectionStatus` varchar(256) NULL COMMENT '验货状态',
`inspectionWorkerID` bigint(20) NULL COMMENT '验货员工编号',
`inspectionWorkerName` varchar(256) NULL COMMENT '验货员工姓名',
`inspectionTime` datetime NULL COMMENT '验货时间',
`note` varchar(256) NULL COMMENT '备注',
PRIMARY KEY (`id`)
) COMMENT='出库验货实体';


CREATE TABLE `Packaged` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`outBoundOrderID` bigint(20) NULL COMMENT '出库订单编号',
`packagedStatus` varchar(256) NULL COMMENT '打包状态',
`packagedWorkerID` bigint(20) NULL COMMENT '打包员工编号',
`packagedWorkerName` varchar(256) NULL COMMENT '打包员工姓名',
`packagedTime` datetime NULL COMMENT '打包时间',
`boxID` bigint(20) NULL COMMENT '箱号',
`volume` decimal(31,2) NULL COMMENT '体积',
PRIMARY KEY (`id`)
) COMMENT='打包实体';


CREATE TABLE `DirectOutboundGoods` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`goodId` bigint(20) NULL COMMENT '货物编号',
`name` varchar(256) NULL COMMENT '货物名称',
`unit` varchar(256) NULL COMMENT '货物单位',
`outboundCount` bigint(20) NULL COMMENT '出库数量',
`outboundDate` datetime NULL COMMENT '出库时间',
`warehouseName` varchar(256) NULL COMMENT '仓库名称',
`warehouseareaName` varchar(256) NULL COMMENT '货区名称',
`shelfName` varchar(256) NULL COMMENT '货架名称',
PRIMARY KEY (`id`)
);


CREATE TABLE `AfterSaleGood` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`afterSaleId` bigint(20) NULL COMMENT '售后单号',
`name` varchar(256) NULL COMMENT '货物名称',
`quantity` bigint(20) NULL COMMENT '货物数量',
`unit` varchar(256) NULL COMMENT '单位',
`status` varchar(256) NULL COMMENT '入库状态',
`notes` varchar(4000) NULL COMMENT '备注',
`goodCategory` varchar(256) NULL COMMENT '货物类型',
PRIMARY KEY (`id`)
);


CREATE TABLE `AfterSalesOrder` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '售后单号',
`customerName` varchar(256) NULL COMMENT '顾客名称',
`responsible` varchar(256) NULL COMMENT '负责人',
`totalAmount` decimal(31,2) NULL COMMENT '总金额',
`numberOfCargoEntries` bigint(20) NULL COMMENT '货物条目数量',
`notes` varchar(256) NULL COMMENT '备注',
`idTag` varchar(256) NULL COMMENT '编号',
`orderDateTime` datetime NULL COMMENT '订单时间',
`status` varchar(256) NULL COMMENT '售后订单状态',
PRIMARY KEY (`id`)
);


CREATE TABLE `Shipping` (
`id` bigint(20) NOT NULL COMMENT '主键',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`createdTime` datetime NULL COMMENT '创建时间',
`outBoundOrderID` bigint(20) NULL COMMENT '出货订单编号',
`shippingWorkerID` bigint(20) NULL COMMENT '发货员工编号',
`shippingWorkerName` varchar(256) NULL COMMENT '发货员工姓名',
`shippingStatus` varchar(256) NULL COMMENT '发货状态',
`expressId` varchar(256) NULL COMMENT '快递单号',
`expressCompany` varchar(256) NULL COMMENT '快递公司',
`shippingTime` datetime NULL COMMENT '发货时间',
PRIMARY KEY (`id`)
) COMMENT='发货表';


CREATE TABLE `OutBoundWeighing` (
`id` bigint(20) NOT NULL COMMENT '主键',
`orderID` bigint(20) NULL COMMENT '出库订单编号',
`outBoundGoodID` bigint(20) NULL COMMENT '货物编号',
`weighingWorkerID` bigint(20) NULL COMMENT '称重员工编号',
`weighingWorkerName` varchar(256) NULL COMMENT '称重员工姓名',
`weighingTime` datetime NULL COMMENT '称重时间',
`weight` decimal(31,2) NULL COMMENT '货物总重量',
PRIMARY KEY (`id`)
) COMMENT='出库称重表';


CREATE TABLE `OutBoundSecSorting` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`packingID` bigint(20) NULL COMMENT '配货表编号',
`statusSec` varchar(256) NULL COMMENT '二次分拣状态',
`secSortingWorkerID` bigint(20) NULL COMMENT '二次分拣员工编号',
`secSortingWorkerName` varchar(256) NULL COMMENT '二次分拣员工姓名',
`secSortingData` datetime NULL COMMENT '二次分拣时间',
`outBoundTmpArea` varchar(256) NULL COMMENT '出库暂留区',
PRIMARY KEY (`id`)
) COMMENT='出库分拣';


CREATE TABLE `OutBoundSorting` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`packingID` bigint(20) NULL COMMENT '配货表编号',
`status` varchar(256) NULL COMMENT '分拣状态',
`sortingWorkerID` bigint(20) NULL COMMENT '分拣员工编号',
`sortingWorkerName` varchar(256) NULL COMMENT '分拣员工姓名',
`sortingData` datetime NULL COMMENT '分拣时间',
`outBoundTmpArea` varchar(256) NULL COMMENT '出库暂留区',
PRIMARY KEY (`id`)
) COMMENT='出库分拣';


CREATE TABLE `InBoundGood` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`inboundOrderId` bigint(20) NULL COMMENT '入库订单编号',
`name` varchar(256) NULL COMMENT '货物名称',
`quantity` bigint(20) NULL COMMENT '货物数量',
`unit` varchar(256) NULL COMMENT '单位',
`status` varchar(256) NULL COMMENT '入库状态',
`inboundPrice` decimal(31,2) NULL COMMENT '入库价格',
`createdTime` datetime NULL COMMENT '创建时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedTime` datetime NULL COMMENT '更新时间',
`inboundTime` datetime NULL COMMENT '入库时间',
`inboundOp` varchar(256) NULL COMMENT '入库操作者',
`refuseReason` varchar(256) NULL COMMENT '拒绝原因',
`note` varchar(256) NULL COMMENT '备注',
`goodCategory` varchar(256) NULL COMMENT '货物类型',
PRIMARY KEY (`id`)
);


CREATE TABLE `OutboundPacking` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`outboundGoodId` bigint(20) NULL COMMENT '商品编号',
`quantity` bigint(20) NULL COMMENT '数量',
`warehouseAreaId` bigint(20) NULL COMMENT '仓库库区编号',
`shelfId` bigint(20) NULL COMMENT '货架编号',
`outboundTmpareaId` bigint(20) NULL COMMENT '出库暂存区',
`status` varchar(256) NULL COMMENT '状态',
`outboundCommodityName` varchar(256) NULL COMMENT '出库商品名称',
`outBoundOrderID` bigint(20) NULL COMMENT '出库订单编号',
PRIMARY KEY (`id`)
);


CREATE TABLE `OutBoundGood` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`outboundOrderId` bigint(20) NULL COMMENT '出库订单编号',
`name` varchar(256) NULL COMMENT '货物名称',
`quantity` bigint(20) NULL COMMENT '货物数量',
`unit` varchar(256) NULL COMMENT '单位',
`status` varchar(256) NULL COMMENT '货物状态',
`weight` decimal(31,2) NULL COMMENT '重量',
PRIMARY KEY (`id`)
) COMMENT='出库货物';


CREATE TABLE `OutboundOrder` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`customerName` varchar(256) NULL COMMENT '顾客名称',
`amount` decimal(31,2) NULL COMMENT '总金额',
`goodsNum` bigint(20) NULL COMMENT '货物条目数量',
`outboundOrderCreatedTime` datetime NULL COMMENT '出库订单创建时间',
`responsiblePerson` varchar(256) NULL COMMENT '负责人',
`status` varchar(256) NULL COMMENT '状态',
`errorDescription` varchar(256) NULL COMMENT '错误描述',
PRIMARY KEY (`id`)
);


CREATE TABLE `Shelf` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` varchar(256) NULL COMMENT '货架名称',
`warehouseAreaId` bigint(20) NULL COMMENT '货区编号',
`createdTime` datetime NULL COMMENT '创建时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`idTag` varchar(256) NULL,
`status` varchar(256) NULL,
`capacity` bigint(20) NULL DEFAULT 100 COMMENT '容量',
`currentQuantity` bigint(20) NULL DEFAULT 0 COMMENT '当前库存',
`preference` varchar(256) NULL COMMENT '货架偏好',
PRIMARY KEY (`id`)
) COMMENT='货架';


CREATE TABLE `WarehouseArea` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` varchar(256) NULL COMMENT '库区名称',
`warehouseId` bigint(20) NULL COMMENT '仓库编号',
`category` varchar(256) NULL COMMENT '库区种类',
`idTag` varchar(256) NULL COMMENT '库区编号',
`createdTime` datetime NULL COMMENT '创建时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`status` varchar(256) NULL DEFAULT '0' COMMENT '状态',
`capacity` bigint(20) NULL DEFAULT 1000 COMMENT '容量',
`currentQuantity` bigint(20) NULL DEFAULT 0 COMMENT '当前库存',
PRIMARY KEY (`id`)
) COMMENT='库区';


CREATE TABLE `Warehouse` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` varchar(256) NULL COMMENT '仓库名称',
`idTag` varchar(256) NULL COMMENT '仓库编号',
`createdTime` datetime NULL COMMENT '创建时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`status` varchar(256) NULL COMMENT '状态',
`balance` decimal(31,2) NULL COMMENT '余额',
`capacity` bigint(20) NULL DEFAULT 10000,
`currentQuantity` bigint(20) NULL DEFAULT 1000,
PRIMARY KEY (`id`)
);


CREATE TABLE `Orders` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`customerName` varchar(256) NULL COMMENT '客户名称',
`amount` decimal(31,2) NULL COMMENT '总金额',
`goodsNum` bigint(20) NULL COMMENT '货物条目数量',
`responsiblePerson` varchar(256) NULL COMMENT '负责人',
`expectedDate` datetime NULL COMMENT '预计到货时间',
`arrivalDate` datetime NULL COMMENT '实际到货时间',
`notes` text NULL COMMENT '备注',
`status` varchar(256) NULL COMMENT '订单状态',
`refuseReason` text NULL COMMENT '拒单说明',
`idTag` varchar(256) NULL COMMENT '订单编号',
PRIMARY KEY (`id`)
);


CREATE TABLE `Application` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`username` varchar(256) NULL COMMENT '用户名',
`accessType` varchar(256) NULL COMMENT '权限种类',
`status` varchar(256) NULL COMMENT '申请状态',
`refuseReason` text NULL COMMENT '拒绝理由',
`applyReason` text NULL COMMENT '申请原因',
`userId` bigint(20) NULL COMMENT '申请用户Id',
PRIMARY KEY (`id`)
);


CREATE TABLE `Goods` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
`category` varchar(256) NULL COMMENT '种类',
`name` varchar(256) NULL COMMENT '货物名称',
`status` varchar(256) NULL COMMENT '其他状态',
`quantity` bigint(20) NULL COMMENT '货物数量',
`unit` varchar(256) NULL COMMENT '货物单位',
`inboundDate` datetime NULL COMMENT '入库时间',
`inboundOp` varchar(256) NULL COMMENT '入库操作者',
`outboundDate` datetime NULL COMMENT '出库时间',
`outboundOp` varchar(256) NULL COMMENT '出库操作者',
`notes` varchar(256) NULL COMMENT '备注',
`inboundTmpArea` bigint(20) NULL COMMENT '入库暂存区',
`warehouseId` bigint(20) NULL COMMENT '仓库编号',
`storageAreaId` bigint(20) NULL COMMENT '库区编号',
`shelfId` bigint(20) NULL COMMENT '货架编号',
`orderId` bigint(20) NULL COMMENT '订单入库订单编号',
`refuseReason` varchar(256) NULL COMMENT '拒绝原因',
`inboundPrice` decimal(31,2) NULL COMMENT '入库价格',
`outboundPrice` decimal(31,2) NULL COMMENT '出库价格',
`idTag` varchar(256) NULL COMMENT '货物编号',
`onShelfTime` datetime NULL COMMENT '上架时间',
`onShelfOp` varchar(256) NULL COMMENT '上架操作者',
`commodityId` bigint(20) NULL COMMENT '商品id',
`afterSaleId` bigint(20) NULL COMMENT '售后id编号',
`goodCategory` varchar(256) NULL COMMENT '产品类别',
PRIMARY KEY (`id`)
);


CREATE TABLE `Userinfo` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '注册时间',
`username` varchar(256) NULL COMMENT '用户名',
`password` varchar(256) NULL COMMENT '密码',
`phone` varchar(256) NULL COMMENT '手机号',
`name` varchar(256) NULL COMMENT '名字',
`avatar` text NULL COMMENT '用户头像',
`sex` varchar(256) NULL COMMENT '性别',
`isInbound` varchar(256) NULL COMMENT '入库管理权限',
`isOutbound` varchar(256) NULL COMMENT '出库管理权限',
`isDistribution` varchar(256) NULL COMMENT '配送管理权限',
`isWarefareManage` varchar(256) NULL COMMENT '仓内管理权限',
`isFinance` varchar(256) NULL COMMENT '财政管理权限',
`isAdmin` varchar(256) NULL COMMENT '管理员',
`warehouseId` bigint(20) NULL COMMENT '仓库编号',
`createdBy` varchar(256) NULL COMMENT '创建者',
`orderInboundCount` bigint(20) NULL DEFAULT 0 COMMENT '订单入库单数',
`orderOutboundCount` bigint(20) NULL DEFAULT 0 COMMENT '订单出库单数',
`afterSaleInboundCount` bigint(20) NULL DEFAULT 0 COMMENT '售后入库单数',
`afterSaleOutboundCount` bigint(20) NULL DEFAULT 0 COMMENT '售后出库单数',
`otherInboundCount` bigint(20) NULL DEFAULT 0 COMMENT '其它入库单数',
`otherOutboundCount` bigint(20) NULL DEFAULT 0 COMMENT '其它出库单数',
PRIMARY KEY (`id`)
);


CREATE TABLE `LoginUser` (
`id` bigint(20) NOT NULL COMMENT '主键',
`username` varchar(256) NOT NULL COMMENT '账号',
`createdTime` datetime NULL COMMENT '创建时间',
`password` varchar(256) NOT NULL COMMENT '密码',
PRIMARY KEY (`id`)
);


CREATE TABLE `LCAPLogicViewMapping_79f632` (
`id` bigint(20) NOT NULL COMMENT '主键',
`logicIdentifier` varchar(256) NOT NULL COMMENT '/api/logic1:GET',
`resourceName` varchar(256) NOT NULL COMMENT '/dashboard/button1',
`resourceType` varchar(256) NOT NULL COMMENT '页面-page 组件-component 逻辑-logic',
`group` bigint(20) NOT NULL COMMENT '值一样的为同一组',
`changeTime` bigint(20) NULL COMMENT '创建时间',
PRIMARY KEY (`id`)
) COMMENT='记录应用全局逻辑与页面资源的关联关系';


CREATE TABLE `LCAPUser_79f632` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`userId` varchar(256) NOT NULL COMMENT '第三方登录方式唯一id；普通登录使用userName+source作为userId',
`userName` varchar(256) NOT NULL COMMENT '普通登录用户名，类似账号的概念',
`password` varchar(256) NULL COMMENT '普通登录密码，密码建议加密存储。第三方登录不会存储密码',
`phone` varchar(256) NULL COMMENT '手机号',
`email` varchar(256) NULL COMMENT '邮箱',
`displayName` varchar(256) NULL COMMENT '展示的名称',
`status` varchar(256) NULL DEFAULT 'Normal' COMMENT '状态，标识当前用户的状态是什么',
`source` varchar(256) NOT NULL DEFAULT 'Normal' COMMENT '当前条用户数据来自哪个用户源，如普通登录、微信登录',
PRIMARY KEY (`id`)
) COMMENT='制品应用的用户实体。
1 实体名称不允许改动
2 默认生成的字段不允许改动
3 可新增自定义字段（避免设置为非空且无默认值）';


CREATE TABLE `LCAPRolePerMapping_79f632` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`roleId` bigint(20) NOT NULL COMMENT '角色唯一ID',
`permissionId` bigint(20) NOT NULL COMMENT '权限唯一ID',
PRIMARY KEY (`id`)
) COMMENT='角色权限关联实体。新增角色一般需要新增角色对应的权限。默认生成的字段不允许改动，可新增自定义字段。';


CREATE TABLE `LCAPPerResMapping_79f632` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`permissionId` bigint(20) NOT NULL COMMENT '权限唯一ID',
`resourceId` bigint(20) NOT NULL COMMENT '资源唯一ID',
PRIMARY KEY (`id`)
) COMMENT='权限与资源的关联实体。一组权限会包含若干资源路径，权限对应角色。为角色绑定移除资源需操作该表。默认字段不允许改动，可新增字段。';


CREATE TABLE `LCAPUserRoleMapping_79f632` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`userId` varchar(256) NOT NULL COMMENT '用户唯一ID',
`roleId` bigint(20) NOT NULL COMMENT '角色唯一ID',
`userName` varchar(256) NULL COMMENT '用户名',
`source` varchar(256) NULL COMMENT '用户来源',
PRIMARY KEY (`id`)
) COMMENT='用户与角色关联实体。操作该表可完成为角色添加成员、移除角色成员等。默认生成的字段不允许改动，可新增自定义字段。';


CREATE TABLE `LCAPRole_79f632` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`uuid` varchar(256) NULL COMMENT '唯一标识',
`name` varchar(256) NOT NULL COMMENT '角色名',
`description` varchar(256) NULL COMMENT '角色描述',
`roleStatus` tinyint(1) NULL DEFAULT 1 COMMENT '角色状态，可配置true启用，false禁用。',
`editable` tinyint(1) NULL DEFAULT 1 COMMENT '系统字段，请勿修改。web新增为可编辑true，ide新增为不可编辑false。',
PRIMARY KEY (`id`)
) COMMENT='用户与角色关联实体。操作该表可完成为角色添加成员、移除角色成员等。默认生成的字段不允许改动，可新增自定义字段。';


CREATE TABLE `LCAPPermission_79f632` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`uuid` varchar(256) NULL COMMENT '唯一标识',
`name` varchar(256) NOT NULL COMMENT '权限名称',
`description` varchar(256) NULL COMMENT '权限描述',
PRIMARY KEY (`id`)
) COMMENT='权限实体。新增角色的同时要一般需要绑定角色对应的权限。默认生成的字段不允许改动，可新增自定义字段。';


CREATE TABLE `LCAPResource_79f632` (
`id` bigint(20) NOT NULL COMMENT '主键',
`createdTime` datetime NULL COMMENT '创建时间',
`updatedTime` datetime NULL COMMENT '更新时间',
`createdBy` varchar(256) NULL COMMENT '创建者',
`updatedBy` varchar(256) NULL COMMENT '更新者',
`uuid` varchar(256) NULL COMMENT '唯一标识',
`name` varchar(256) NOT NULL COMMENT '资源路径，如/test/api',
`description` varchar(256) NULL COMMENT '资源描述',
`type` varchar(256) NULL COMMENT '资源类型',
`clientType` varchar(256) NULL COMMENT '端标识',
PRIMARY KEY (`id`)
) COMMENT='资源实体。该表的数据是新建组件后，系统自动上报的。name字段对应资源路径。默认生成的字段不允许改动，可新增自定义字段。';


