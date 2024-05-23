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
* auto generate AnonymousStructure_CAC5152BAE2C91DD609E3DFEE343ACC6 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_CAC5152BAE2C91DD609E3DFEE343ACC6 {
    public List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_70791B893F53C2EFB9E501591763B020> list = new ArrayList <>();
    public Long total;

    public List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_70791B893F53C2EFB9E501591763B020> getList() {
        return list;
    }

    public void setList(List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_70791B893F53C2EFB9E501591763B020> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
