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
* auto generate LoadCANGCHUGUANLITableView6CustomizeController logic
*
* @author sys
*/
@RestController
public class LoadCANGCHUGUANLITableView6CustomizeController {

@Autowired private LoadCANGCHUGUANLITableView6CustomizeService loadCANGCHUGUANLITableView6CustomizeService;

@PostMapping("/api/lcplogics/loadCANGCHUGUANLITableView6")
public ApiReturn<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8B7A01F9E9F20DE75E42AAFB1EC465EE> loadCANGCHUGUANLITableView6(@RequestBody LoadCANGCHUGUANLITableView6CustomizeControllerDto loadCANGCHUGUANLITableView6CustomizeControllerDto) throws Exception {
 return ApiReturn.of(loadCANGCHUGUANLITableView6CustomizeService.loadCANGCHUGUANLITableView6(loadCANGCHUGUANLITableView6CustomizeControllerDto.getPage(),loadCANGCHUGUANLITableView6CustomizeControllerDto.getSize(),loadCANGCHUGUANLITableView6CustomizeControllerDto.getSort(),loadCANGCHUGUANLITableView6CustomizeControllerDto.getOrder()));
}
}
