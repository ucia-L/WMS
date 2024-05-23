package com.weitest.wms.service.logics;

import com.weitest.wms.config.Constants;
import com.weitest.wms.context.UserContext;
import com.weitest.wms.util.*;
import com.weitest.wms.domain.*;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.service.*;
import com.weitest.wms.service.dto.filters.*;
import com.weitest.wms.service.dto.filters.atomic.*;
import com.weitest.wms.service.dto.filters.logic.binary.*;
import com.weitest.wms.service.dto.filters.logic.binary.calculate.*;
import com.weitest.wms.service.dto.filters.logic.binary.compare.*;
import com.weitest.wms.service.dto.filters.logic.binary.logicCalculate.*;
import com.weitest.wms.service.dto.filters.logic.binary.matching.*;
import com.weitest.wms.service.dto.filters.logic.unary.*;
import com.weitest.wms.repository.*;
import com.weitest.wms.exception.HttpCodeException;
import com.weitest.wms.service.system.configuration.*;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.lang.reflect.Field;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.scheduling.annotation.Scheduled;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.RoundingMode;
import com.weitest.wms.service.entities.*;
import com.weitest.wms.functional.FunctionContainer;
import com.weitest.wms.domain.entities.*;
import com.weitest.wms.domain.structure.*;

/**
* auto generate GetTreeOfWarehouseCustomizeService logic
*
* @author sys
*/
@Service
public class GetTreeOfWarehouseCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private GetTreeOfWarehouseCustomizeServiceMapper getTreeOfWarehouseCustomizeServiceMapper;

	public List<TreeStructure>  getTreeOfWarehouse() {
		List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_71AFED732D709AF046E771165E69776D> variable1 = new ArrayList <>();
		List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_F30C4D4796DE57EC4963423784B62512> variable2 = new ArrayList <>();
		List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_46C8A8E71B06F587D170236042B53479> variable3 = new ArrayList <>();
		TreeStructure variable4 = new TreeStructure();
		Long id = 0L;
		Long len1 = 0L;
		Long len2 = 0L;
		List<TreeStructure> result = new ArrayList <>();
		id=0L;
		variable1=CommonFunctionUtil.createListPage(getTreeOfWarehouseCustomizeServiceMapper.getAnonymousStructure_7CC1E5F8E9FC7EB40FE2F6D0BC184542(), getTreeOfWarehouseCustomizeServiceMapper.countAnonymousStructure_7CC1E5F8E9FC7EB40FE2F6D0BC184542().intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_7CC1E5F8E9FC7EB40FE2F6D0BC184542.class).list;
		variable2=CommonFunctionUtil.createListPage(getTreeOfWarehouseCustomizeServiceMapper.getAnonymousStructure_7F0FC9CD7C0E19CDEBEF556E681E6B3C(), getTreeOfWarehouseCustomizeServiceMapper.countAnonymousStructure_7F0FC9CD7C0E19CDEBEF556E681E6B3C().intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_7F0FC9CD7C0E19CDEBEF556E681E6B3C.class).list;
		variable3=CommonFunctionUtil.createListPage(getTreeOfWarehouseCustomizeServiceMapper.getAnonymousStructure_C4FA1D15D6667A010FD16DE68FF5F6F8(), getTreeOfWarehouseCustomizeServiceMapper.countAnonymousStructure_C4FA1D15D6667A010FD16DE68FF5F6F8().intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_C4FA1D15D6667A010FD16DE68FF5F6F8.class).list;
		variable4=CommonFunctionUtil.New(TreeStructure.class);
		for(Long index = 0L; index < CommonFunctionUtil.length(variable1); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_71AFED732D709AF046E771165E69776D  item = variable1.get(index.intValue());
			id=(id + 1L);
			variable4.id=id;
			variable4.name=item.warehouse.name;
			variable4.warehouse_id=item.warehouse.id;
			CommonFunctionUtil.add(result,CommonFunctionUtil.clone(variable4));
		}
		CommonFunctionUtil.clear(variable4);
		len1=id;
		for(Long index = 0L; index < CommonFunctionUtil.length(variable3); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_46C8A8E71B06F587D170236042B53479  item = variable3.get(index.intValue());
			id=(id + 1L);
			variable4.id=id;
			variable4.name=item.warehouseArea.name;
			variable4.warehouseArea_id=item.warehouseArea.id;
			for(Long index1 = 0L; index1 < len1; index1++ ) {
				TreeStructure  item1 = result.get(index1.intValue());
				if((item1.warehouse_id.equals(item.warehouseArea.warehouse_id))) {
					variable4.parentId=item1.id;
					index1=len1;
				} else {
				}
			}
			if((variable4.parentId != null)) {
				CommonFunctionUtil.add(result,CommonFunctionUtil.clone(variable4));
			} else {
			}
		}
		len2=id;
		for(Long index = 0L; index < CommonFunctionUtil.length(variable2); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_F30C4D4796DE57EC4963423784B62512  item = variable2.get(index.intValue());
			id=(id + 1L);
			variable4.id=id;
			variable4.name=item.shelf.name;
			variable4.shelf_id=item.shelf.id;
			for(Long index1 = len1; index1 < len2; index1++ ) {
				TreeStructure  item1 = result.get(index1.intValue());
				if((item1.warehouseArea_id.equals(item.shelf.warehouseArea_id))) {
					variable4.parentId=item1.id;
					index1=len2;
				} else {
				}
			}
			if((variable4.parentId != null)) {
				CommonFunctionUtil.add(result,CommonFunctionUtil.clone(variable4));
			} else {
			}
		}
		return result;
	}


}
