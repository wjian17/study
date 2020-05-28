package org.company.forward.study.kafka;

import org.company.forward.db.config.DataSourceAspect;
import org.company.forward.db.config.DynamicDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import(value = {DynamicDataSourceConfig.class, DataSourceAspect.class})
@EnableDiscoveryClient
@MapperScan(value = "com.company.forward.study.kafka.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableFeignClients
@EnableHystrix
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class StudyKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyKafkaApplication.class, args);
    }

}
