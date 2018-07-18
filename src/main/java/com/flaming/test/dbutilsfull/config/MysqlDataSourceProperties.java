package com.flaming.test.dbutilsfull.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author xiaolin.tang
 * @date 2018/7/18 11:10
 */
@Data
@ConfigurationProperties(prefix = "mysql.datasource")
public class MysqlDataSourceProperties {

    private String driver;
    private String url;
    private String username;
    private String password;

}
