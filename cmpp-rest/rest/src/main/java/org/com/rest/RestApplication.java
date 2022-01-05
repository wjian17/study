package org.com.rest;

import lombok.extern.slf4j.Slf4j;
import org.cmp.core.annotation.EnableAdapterMgr;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */
@Slf4j
@EnableWebMvc
@EnableAdapterMgr(basePackages = {"org.cmp.*"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"org.cmp.*"})
@SpringBootApplication(scanBasePackages = {"org.cmp.*"})
public class RestApplication {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(RestApplication.class,args);
        log.info("################################################");
        log.info("####: Service was started:{} seconds.",(System.currentTimeMillis()-start)/1000);
        log.info("################################################");
    }
}
