package org.cmp.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 */
@Slf4j
@EnableWebMvc
@SpringCloudApplication
public class GateWayApplication {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(GateWayApplication.class,args);
        log.info("################################################");
        log.info("####: Service was started:{} seconds.",(System.currentTimeMillis()-start)/1000);
        log.info("################################################");
    }
}
