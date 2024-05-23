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
* auto generate AnonymousStructure_72289247231C392228DF67461D1CE7EA structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_72289247231C392228DF67461D1CE7EA {
    public String warehouse_name;
    public Long w_id;
    public String warehouse_area_name;
    public Long wa_id;
    public String shelf_nam;
    public Long s_id;

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public Long getW_id() {
        return w_id;
    }

    public void setW_id(Long w_id) {
        this.w_id = w_id;
    }

    public String getWarehouse_area_name() {
        return warehouse_area_name;
    }

    public void setWarehouse_area_name(String warehouse_area_name) {
        this.warehouse_area_name = warehouse_area_name;
    }

    public Long getWa_id() {
        return wa_id;
    }

    public void setWa_id(Long wa_id) {
        this.wa_id = wa_id;
    }

    public String getShelf_nam() {
        return shelf_nam;
    }

    public void setShelf_nam(String shelf_nam) {
        this.shelf_nam = shelf_nam;
    }

    public Long getS_id() {
        return s_id;
    }

    public void setS_id(Long s_id) {
        this.s_id = s_id;
    }

}
