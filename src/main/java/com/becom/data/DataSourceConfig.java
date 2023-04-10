package com.becom.data;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    //定义数据源1
    @Bean(name="ds1")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSource ds1(){
        return DataSourceBuilder.create().build();
    }
    //定义数据源1
    @Bean(name="ds2")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSource ds2(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name="dataSource")
    public DataSource dynamicDataSource(@Qualifier("ds1") DataSource ds1,@Qualifier("ds2") DataSource ds2){
        Map<Object,Object> targetDataSource = new HashMap<>();
        targetDataSource.put("ds1",ds1);
        targetDataSource.put("ds2",ds2);
        DyameicDataSource dyameicDataSource = new DyameicDataSource();
        dyameicDataSource.setTargetDataSources(targetDataSource);
        dyameicDataSource.setDefaultTargetDataSource(ds1);
        return dyameicDataSource;
    }
    @Bean
    public JdbcTemplate getJdbcTemplate(@Qualifier("dataSource") DataSource ds1){
        return new JdbcTemplate(ds1);
    }
}
