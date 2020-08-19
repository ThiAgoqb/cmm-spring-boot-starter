package com.cmm.db;

import com.cmm.aop.DataSourceHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        String targetDBName = DataSourceHolder.getTargetDBName();
        if (StringUtils.isNotEmpty(targetDBName)) {
                log.info("当前数据源数据源为：{}", targetDBName);
        }
        return targetDBName;
    }
}
