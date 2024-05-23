package com.weitest.wms.service.dto.filters.logic.binary.calculate;

import com.weitest.wms.service.dto.filters.logic.binary.BinaryExpressionFilter;

/**
 * @Author: sys
 */
public class ModQueryFilter extends BinaryExpressionFilter {

    public ModQueryFilter() {
        this.operator = "%";
    }

    @Override
    public String sql(String dbType) {
        return String.format(" MOD(%s, %s) ", left.sql(dbType), right.sql(dbType));
    }
}
