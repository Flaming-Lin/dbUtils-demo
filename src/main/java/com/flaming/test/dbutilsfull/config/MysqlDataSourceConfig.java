package com.flaming.test.dbutilsfull.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author xiaolin.tang
 * @date 2018/7/18 11:14
 */
@Configuration
@EnableConfigurationProperties(MysqlDataSourceProperties.class)
public class MysqlDataSourceConfig {

    @Bean("mysqlDataSource")
    public DataSource getDataSource(MysqlDataSourceProperties dataSourceProperties){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourceProperties.getDriver());
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        return dataSource;
    }

}
