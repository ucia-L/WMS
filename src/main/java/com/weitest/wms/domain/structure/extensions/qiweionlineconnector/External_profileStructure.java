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
* auto generate External_profileStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class External_profileStructure {
    public String external_corp_name;
    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Wechat_channelsStructure wechat_channels;
    public List<com.weitest.wms.domain.structure.extensions.qiweionlineconnector.External_attrStructure> external_attr = new ArrayList <>();

    public String getExternal_corp_name() {
        return external_corp_name;
    }

    public void setExternal_corp_name(String external_corp_name) {
        this.external_corp_name = external_corp_name;
    }

    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Wechat_channelsStructure getWechat_channels() {
        return wechat_channels;
    }

    public void setWechat_channels(com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Wechat_channelsStructure wechat_channels) {
        this.wechat_channels = wechat_channels;
    }

    public List<com.weitest.wms.domain.structure.extensions.qiweionlineconnector.External_attrStructure> getExternal_attr() {
        return external_attr;
    }

    public void setExternal_attr(List<com.weitest.wms.domain.structure.extensions.qiweionlineconnector.External_attrStructure> external_attr) {
        this.external_attr = external_attr;
    }

}
