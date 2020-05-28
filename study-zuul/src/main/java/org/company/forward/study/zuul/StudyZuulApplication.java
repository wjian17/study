package org.company.forward.study.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class StudyZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyZuulApplication.class, args);
    }

}
