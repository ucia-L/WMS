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
* auto generate AnonymousStructure_E3C62BD932173A0ED274FCAFD69E4C99 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_E3C62BD932173A0ED274FCAFD69E4C99 {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_4E3EBFA05CBF2B62FE384E49B797C286 shelf;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_4E3EBFA05CBF2B62FE384E49B797C286 getShelf() {
        return shelf;
    }

    public void setShelf(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_4E3EBFA05CBF2B62FE384E49B797C286 shelf) {
        this.shelf = shelf;
    }

}
