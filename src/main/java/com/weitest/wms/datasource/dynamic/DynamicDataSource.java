package com.weitest.wms.datasource.dynamic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.jdbc.datasource.lookup.BeanFactoryDataSourceLookup;

/**
 * @author sys
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> currentDataSource = new ThreadLocal<>();

    public DynamicDataSource(BeanFactory beanFactory) {
        setDataSourceLookup(new BeanFactoryDataSourceLookup(beanFactory));
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return currentDataSource.get();
    }

    public static void setCurrentDataSource(String dataSource) {
        currentDataSource.set(dataSource);
    }

    public static void clearCurrentDataSource() {
        currentDataSource.remove();
    }
}
