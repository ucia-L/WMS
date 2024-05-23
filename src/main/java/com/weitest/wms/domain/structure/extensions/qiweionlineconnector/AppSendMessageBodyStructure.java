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
* auto generate AppSendMessageBodyStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AppSendMessageBodyStructure {
    public String touser;
    public String toparty;
    public String totag;
    public String msgtype;
    public Long agentid;
    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Text4Structure text;
    public Long safe;
    public Long enable_id_trans;
    public Long enable_duplicate_check;
    public Long duplicate_check_interval;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getTotag() {
        return totag;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Text4Structure getText() {
        return text;
    }

    public void setText(com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Text4Structure text) {
        this.text = text;
    }

    public Long getSafe() {
        return safe;
    }

    public void setSafe(Long safe) {
        this.safe = safe;
    }

    public Long getEnable_id_trans() {
        return enable_id_trans;
    }

    public void setEnable_id_trans(Long enable_id_trans) {
        this.enable_id_trans = enable_id_trans;
    }

    public Long getEnable_duplicate_check() {
        return enable_duplicate_check;
    }

    public void setEnable_duplicate_check(Long enable_duplicate_check) {
        this.enable_duplicate_check = enable_duplicate_check;
    }

    public Long getDuplicate_check_interval() {
        return duplicate_check_interval;
    }

    public void setDuplicate_check_interval(Long duplicate_check_interval) {
        this.duplicate_check_interval = duplicate_check_interval;
    }

}
