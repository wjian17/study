package com.company.forward.study.rest;

import org.company.forward.db.config.DataSourceAspect;
import org.company.forward.db.config.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import(value = {DynamicDataSourceConfig.class, DataSourceAspect.class})
@EnableDiscoveryClient
@MapperScan(value = "com.company.forward.study.rest.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableFeignClients
@EnableHystrix
public class StudyRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyRestApplication.class, args);
    }

}
