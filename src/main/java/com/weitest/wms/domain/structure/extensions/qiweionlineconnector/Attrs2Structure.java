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
* auto generate Attrs2Structure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class Attrs2Structure {
    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.WebStructure web;
    public String name;
    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Text2Structure text;
    public Long type;

    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.WebStructure getWeb() {
        return web;
    }

    public void setWeb(com.weitest.wms.domain.structure.extensions.qiweionlineconnector.WebStructure web) {
        this.web = web;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Text2Structure getText() {
        return text;
    }

    public void setText(com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Text2Structure text) {
        this.text = text;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

}
