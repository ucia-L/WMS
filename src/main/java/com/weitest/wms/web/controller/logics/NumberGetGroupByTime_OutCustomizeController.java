package com.weitest.wms.web.controller.logics;

import com.weitest.wms.util.*;
import com.weitest.wms.context.UserContext;
import com.weitest.wms.domain.*;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.service.*;
import com.weitest.wms.service.logics.*;
import com.weitest.wms.repository.*;
import com.weitest.wms.web.ApiReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import com.weitest.wms.service.entities.*;
import com.weitest.wms.web.controller.logics.dto.*;
import com.weitest.wms.domain.entities.*;
import com.weitest.wms.domain.structure.*;

/**
* auto generate NumberGetGroupByTime_OutCustomizeController logic
*
* @author sys
*/
@RestController
public class NumberGetGroupByTime_OutCustomizeController {

@Autowired private NumberGetGroupByTime_OutCustomizeService numberGetGroupByTime_OutCustomizeService;

@PostMapping("/api/lcplogics/NumberGetGroupByTime_Out")
public ApiReturn<List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_77D54F32F3F9CC14A0EA5BBAD9D1D9BE>> numberGetGroupByTime_Out(@RequestBody NumberGetGroupByTime_OutCustomizeControllerDto numberGetGroupByTime_OutCustomizeControllerDto) throws Exception {
 return ApiReturn.of(numberGetGroupByTime_OutCustomizeService.numberGetGroupByTime_Out(numberGetGroupByTime_OutCustomizeControllerDto.getType()));
}
}