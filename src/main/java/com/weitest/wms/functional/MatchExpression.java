package com.weitest.wms.functional;

/**
 * matchExpression函数接口声明
 * @param <Param>
 * @param <Result>
 */
@FunctionalInterface
public interface MatchExpression<Param, Result> {
    Result match(Param param);
}
