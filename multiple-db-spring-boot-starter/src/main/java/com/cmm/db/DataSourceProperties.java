package com.cmm.db;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.sql.DataSource;
import java.util.Map;
import java.util.TreeMap;

@Data
@ConfigurationProperties(prefix = "spring.cmm")
public class DataSourceProperties {

    private Class<? extends DataSource> type;

    private Map<String, DataSourceBase> dataSource;

    private TreeMap<Long, String> resizedb;
}
