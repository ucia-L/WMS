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
* auto generate AnonymousStructure_1AF446F0FE2D7B6C232132FCD3B29D44 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_1AF446F0FE2D7B6C232132FCD3B29D44 {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_FC8C5AA76D6EBC241E0F4EE65043445B shelf;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_FC8C5AA76D6EBC241E0F4EE65043445B getShelf() {
        return shelf;
    }

    public void setShelf(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_FC8C5AA76D6EBC241E0F4EE65043445B shelf) {
        this.shelf = shelf;
    }

}
