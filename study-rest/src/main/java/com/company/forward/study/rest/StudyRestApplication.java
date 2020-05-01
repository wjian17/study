package com.company.forward.study.rest;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.company.forward.db.config.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class,DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.company.forward.study.rest.mapper"})
@Import(DynamicDataSourceConfig.class)
@ComponentScan(basePackages = {"com.company.forward.study"})
public class StudyRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyRestApplication.class, args);
    }

}
