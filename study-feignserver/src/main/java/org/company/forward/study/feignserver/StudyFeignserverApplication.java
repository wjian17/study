package org.company.forward.study.feignserver;

import org.company.forward.db.config.DataSourceAspect;
import org.company.forward.db.config.DynamicDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import(value = {DynamicDataSourceConfig.class, DataSourceAspect.class})
@MapperScan(basePackages = {"org.company.forward.study.feignserver.mapper"})
@EnableCaching
public class StudyFeignserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyFeignserverApplication.class, args);
    }

}
