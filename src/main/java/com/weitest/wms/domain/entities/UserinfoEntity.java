package com.weitest.wms.domain.entities;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigDecimal;
import java.util.UUID;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

import com.weitest.wms.domain.entities.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.annotation.Label;
import com.weitest.wms.config.DateTimeFormatConfiguration;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
* auto generate UserinfoEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class UserinfoEntity {
    @Label("主键")
    @javax.validation.constraints.NotNull
    public Long id;
    @Label("注册时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime createdTime;
    @Label("用户名")
    public String username;
    @Label("密码")
    public String password;
    @Label("手机号")
    public String phone;
    @Label("名字")
    public String name;
    @Label("用户头像")
    public String avatar = "";
    @Label("性别")
    public SexEnum sex;
    @Label("入库管理权限")
    public ApplyStatusEnum is_inbound;
    @Label("出库管理权限")
    public ApplyStatusEnum is_outbound;
    @Label("配送管理权限")
    public ApplyStatusEnum is_distribution;
    @Label("仓内管理权限")
    public ApplyStatusEnum is_warefareManage;
    @Label("财政管理权限")
    public ApplyStatusEnum is_finance;
    @Label("管理员")
    public ApplyStatusEnum is_admin;
    @Label("仓库编号")
    public Long warehouse_id;
    @Label("创建者")
    public String createdBy;
    @Label("订单入库单数")
    public Long orderInbound_count = 0L;
    @Label("订单出库单数")
    public Long orderOutbound_count = 0L;
    @Label("售后入库单数")
    public Long afterSaleInbound_count = 0L;
    @Label("售后出库单数")
    public Long afterSaleOutbound_count = 0L;
    @Label("其它入库单数")
    public Long otherInbound_count = 0L;
    @Label("其它出库单数")
    public Long otherOutbound_count = 0L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.time.ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(java.time.ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public ApplyStatusEnum getIs_inbound() {
        return is_inbound;
    }

    public void setIs_inbound(ApplyStatusEnum is_inbound) {
        this.is_inbound = is_inbound;
    }

    public ApplyStatusEnum getIs_outbound() {
        return is_outbound;
    }

    public void setIs_outbound(ApplyStatusEnum is_outbound) {
        this.is_outbound = is_outbound;
    }

    public ApplyStatusEnum getIs_distribution() {
        return is_distribution;
    }

    public void setIs_distribution(ApplyStatusEnum is_distribution) {
        this.is_distribution = is_distribution;
    }

    public ApplyStatusEnum getIs_warefareManage() {
        return is_warefareManage;
    }

    public void setIs_warefareManage(ApplyStatusEnum is_warefareManage) {
        this.is_warefareManage = is_warefareManage;
    }

    public ApplyStatusEnum getIs_finance() {
        return is_finance;
    }

    public void setIs_finance(ApplyStatusEnum is_finance) {
        this.is_finance = is_finance;
    }

    public ApplyStatusEnum getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(ApplyStatusEnum is_admin) {
        this.is_admin = is_admin;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getOrderInbound_count() {
        return orderInbound_count;
    }

    public void setOrderInbound_count(Long orderInbound_count) {
        this.orderInbound_count = orderInbound_count;
    }

    public Long getOrderOutbound_count() {
        return orderOutbound_count;
    }

    public void setOrderOutbound_count(Long orderOutbound_count) {
        this.orderOutbound_count = orderOutbound_count;
    }

    public Long getAfterSaleInbound_count() {
        return afterSaleInbound_count;
    }

    public void setAfterSaleInbound_count(Long afterSaleInbound_count) {
        this.afterSaleInbound_count = afterSaleInbound_count;
    }

    public Long getAfterSaleOutbound_count() {
        return afterSaleOutbound_count;
    }

    public void setAfterSaleOutbound_count(Long afterSaleOutbound_count) {
        this.afterSaleOutbound_count = afterSaleOutbound_count;
    }

    public Long getOtherInbound_count() {
        return otherInbound_count;
    }

    public void setOtherInbound_count(Long otherInbound_count) {
        this.otherInbound_count = otherInbound_count;
    }

    public Long getOtherOutbound_count() {
        return otherOutbound_count;
    }

    public void setOtherOutbound_count(Long otherOutbound_count) {
        this.otherOutbound_count = otherOutbound_count;
    }

}