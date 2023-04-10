package com.becom.data;

import com.becom.common.DataSourceContextHolder;
import org.apache.naming.factory.DataSourceLinkFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DyameicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
