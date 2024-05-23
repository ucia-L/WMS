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
* auto generate LoadCommoditiesForPurchaseCustomizeController logic
*
* @author sys
*/
@RestController
public class LoadCommoditiesForPurchaseCustomizeController {

@Autowired private LoadCommoditiesForPurchaseCustomizeService loadCommoditiesForPurchaseCustomizeService;

@PostMapping("/api/lcplogics/loadCommoditiesForPurchase")
public ApiReturn<List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D3A798E5313781AC13C96C5E0CDD841E>> loadCommoditiesForPurchase(@RequestBody LoadCommoditiesForPurchaseCustomizeControllerDto loadCommoditiesForPurchaseCustomizeControllerDto) throws Exception {
 return ApiReturn.of(loadCommoditiesForPurchaseCustomizeService.loadCommoditiesForPurchase(loadCommoditiesForPurchaseCustomizeControllerDto.getWarehouse_id()));
}
}
