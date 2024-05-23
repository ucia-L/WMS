package com.weitest.wms.domain.structure.anonymous;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.weitest.wms.annotation.Label;
import com.weitest.wms.domain.*;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.domain.structure.anonymous.*;
import com.weitest.wms.domain.entities.*;

/**
* auto generate AnonymousStructure_293B78F7E0EEAFF27E0B88A23BB4B26B structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_293B78F7E0EEAFF27E0B88A23BB4B26B {
    public Long id;
    public java.time.ZonedDateTime createdTime;
    public String username;
    public String password;
    public String phone;
    public String name;
    public String avatar;
    public SexEnum sex;
    public ApplyStatusEnum is_inbound;
    public ApplyStatusEnum is_outbound;
    public ApplyStatusEnum is_distribution;
    public ApplyStatusEnum is_warefareManage;
    public ApplyStatusEnum is_finance;
    public ApplyStatusEnum is_admin;
    public Long warehouse_id;
    public String createdBy;
    public Long orderInbound_count;
    public Long orderOutbound_count;
    public Long afterSaleInbound_count;
    public Long afterSaleOutbound_count;
    public Long otherInbound_count;
    public Long otherOutbound_count;

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
