package com.cmm;


import com.alibaba.druid.pool.DruidDataSource;
import com.cmm.db.DataSourceBase;
import com.cmm.db.DataSourceProperties;
import com.cmm.db.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@ComponentScan(basePackages = {"com.cmm"})
public class MultiDataSourceAutoConfiguration {


    @Autowired
    private DataSourceProperties properties;


    @Bean
    public Map<Object, Object> dataSources() {
        Map<Object, Object> dbMaps = new HashMap<>();
        properties.getDataSource().forEach((dbName, dataSourceBase) -> {
            try {
                DataSource dataSource = getDataSource(dataSourceBase);
                if (dataSource != null) {
                    dbMaps.put(dbName, dataSource);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return dbMaps;
    }


    public DataSource getDataSource(DataSourceBase data) throws SQLException {
        if (null == data) {
            return null;
        }

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl(data.getUrl());
        druidDataSource.setUsername(data.getUsername());
        druidDataSource.setPassword(data.getPassword());
        druidDataSource.setMaxActive(300);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxOpenPreparedStatements(100);
        druidDataSource.setDefaultAutoCommit(true);
        druidDataSource.setFilters("stat");
        druidDataSource.setMinEvictableIdleTimeMillis(30000);
        druidDataSource.setRemoveAbandonedTimeout(600);
        druidDataSource.setRemoveAbandoned(true);
        druidDataSource.setLogAbandoned(true);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(true);
        druidDataSource.setUseUnfairLock(true);
        druidDataSource.setValidationQuery("select 1");
        List<String> connectionInitSqls = new ArrayList<>();
        connectionInitSqls.add("set names utf8mb4");
        druidDataSource.setConnectionInitSqls(connectionInitSqls);
        return druidDataSource;
    }
    @Bean
    public AbstractRoutingDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dataSources());
        Object defaultDataSource = dataSources().get("default");
        if (defaultDataSource == null) {
            throw new RuntimeException("未配置默认数据源 默认数据源节点为default");
        }
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);
        return dynamicDataSource;
    }
}
