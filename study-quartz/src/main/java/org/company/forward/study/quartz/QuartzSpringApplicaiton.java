package org.company.forward.study.quartz;

import org.company.forward.db.config.DataSourceAspect;
import org.company.forward.db.config.DynamicDataSourceConfig;
import org.company.forward.study.quartz.config.ClassForJarInstallImportSelector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangjian
 * @date 2020/5/29 0029 13:59
 */
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import(value = {DynamicDataSourceConfig.class, DataSourceAspect.class, ClassForJarInstallImportSelector.class})
//@Import(value = {DynamicDataSourceConfig.class, DataSourceAspect.class, RedisCacheConfig.class, RedisConfig.class})
@MapperScan(basePackages = {"org.company.forward.study.quartz.mapper"})
@EnableCaching
@EnableScheduling
public class QuartzSpringApplicaiton {

    public static void main(String[] args) {
        SpringApplication.run(QuartzSpringApplicaiton.class,args);
    }
}
