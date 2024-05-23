package com.weitest.wms.service.dto.filters.logic.binary.calculate;

import com.weitest.wms.service.dto.filters.logic.binary.BinaryExpressionFilter;

/**
 * @Author: sys
 */
public class DivQueryFilter extends BinaryExpressionFilter {

    public DivQueryFilter() {
        this.operator = "/";
    }

    @Override
    public String sql(String dbType) {
        return String.format(" (%s / %s) ", left.sql(dbType), right.sql(dbType));
    }
}
