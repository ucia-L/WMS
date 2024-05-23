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
* auto generate H5SearchOrderCustomizeController logic
*
* @author sys
*/
@RestController
public class H5SearchOrderCustomizeController {

@Autowired private H5SearchOrderCustomizeService h5SearchOrderCustomizeService;

@PostMapping("/api/lcplogics/h5SearchOrder")
public ApiReturn<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3BD8627F316F26B90013F1C52321E84D> h5SearchOrder(@RequestBody H5SearchOrderCustomizeControllerDto h5SearchOrderCustomizeControllerDto) throws Exception {
 return ApiReturn.of(h5SearchOrderCustomizeService.h5SearchOrder(h5SearchOrderCustomizeControllerDto.getId()));
}
}
