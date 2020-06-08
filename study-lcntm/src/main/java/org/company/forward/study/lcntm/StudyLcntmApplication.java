package org.company.forward.study.lcntm;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.company.forward.db.config.DataSourceAspect;
import org.company.forward.db.config.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import(value = {DynamicDataSourceConfig.class, DataSourceAspect.class})
@EnableDiscoveryClient
@EnableTransactionManagerServer
public class StudyLcntmApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyLcntmApplication.class, args);
    }

}
