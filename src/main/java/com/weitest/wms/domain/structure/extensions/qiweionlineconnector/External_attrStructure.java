package com.weitest.wms.domain.structure.extensions.qiweionlineconnector;

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
import com.weitest.wms.domain.entities.*;

/**
* auto generate External_attrStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class External_attrStructure {
    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Web2Structure web;
    public String name;
    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Text3Structure text;
    public Long type;
    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.MiniprogramStructure miniprogram;

    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Web2Structure getWeb() {
        return web;
    }

    public void setWeb(com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Web2Structure web) {
        this.web = web;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Text3Structure getText() {
        return text;
    }

    public void setText(com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Text3Structure text) {
        this.text = text;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.MiniprogramStructure getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(com.weitest.wms.domain.structure.extensions.qiweionlineconnector.MiniprogramStructure miniprogram) {
        this.miniprogram = miniprogram;
    }

}
