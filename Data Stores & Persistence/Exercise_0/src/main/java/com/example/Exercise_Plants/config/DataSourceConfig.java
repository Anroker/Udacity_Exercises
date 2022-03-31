/*
package com.example.Exercise_Plants.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

public class DataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "com.udacity.datasource")
    public DataSource getDataSource() {
        DataSourceBuilder<?> dsb = DataSourceBuilder.create();
        dsb.url("jdbc:mysql://localhost:3306/plant");
        return dsb.build();
    }

}
*/
