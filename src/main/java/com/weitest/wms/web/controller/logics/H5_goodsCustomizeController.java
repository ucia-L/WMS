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
* auto generate H5_goodsCustomizeController logic
*
* @author sys
*/
@RestController
public class H5_goodsCustomizeController {

@Autowired private H5_goodsCustomizeService h5_goodsCustomizeService;

@PostMapping("/api/lcplogics/h5_goods")
public ApiReturn<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87> h5_goods(@RequestBody H5_goodsCustomizeControllerDto h5_goodsCustomizeControllerDto) throws Exception {
 return ApiReturn.of(h5_goodsCustomizeService.h5_goods(h5_goodsCustomizeControllerDto.getParam1()));
}
}
