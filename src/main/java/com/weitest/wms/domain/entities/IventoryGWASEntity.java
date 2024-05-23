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
* auto generate IventoryGWASEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class IventoryGWASEntity {
    @Label("盘点id")
    public Long id;
    @Label("货物id")
    public Long gid;
    @Label("货物名")
    public String g_name;
    @Label("货物数量")
    public Long g_quantity;
    @Label("货物单位")
    public UnitEnum g_unit;
    @Label("仓库id")
    public Long wid;
    @Label("仓库名")
    public String w_name;
    @Label("库区id")
    public Long waid;
    @Label("货区名")
    public String wa_name;
    @Label("货架id")
    public Long sid;
    @Label("货架名")
    public String s_name;
    @Label("日期")
    @JsonFormat(pattern=DateTimeFormatConfiguration.LOCAL_DATE_FORMAT)
    public java.time.LocalDate dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public Long getG_quantity() {
        return g_quantity;
    }

    public void setG_quantity(Long g_quantity) {
        this.g_quantity = g_quantity;
    }

    public UnitEnum getG_unit() {
        return g_unit;
    }

    public void setG_unit(UnitEnum g_unit) {
        this.g_unit = g_unit;
    }

    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public String getW_name() {
        return w_name;
    }

    public void setW_name(String w_name) {
        this.w_name = w_name;
    }

    public Long getWaid() {
        return waid;
    }

    public void setWaid(Long waid) {
        this.waid = waid;
    }

    public String getWa_name() {
        return wa_name;
    }

    public void setWa_name(String wa_name) {
        this.wa_name = wa_name;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public java.time.LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(java.time.LocalDate dateTime) {
        this.dateTime = dateTime;
    }

}