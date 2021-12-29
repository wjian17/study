package org.cmp.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 */
@Slf4j
@EnableWebMvc
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"org.cmp.*"})
@SpringBootApplication(scanBasePackages = {"org.cmp.*"})
public class AppApplication {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(AppApplication.class,args);
        log.info("################################################");
        log.info("####: Service was started:{} seconds.",(System.currentTimeMillis()-start)/1000);
        log.info("################################################");
    }
}
