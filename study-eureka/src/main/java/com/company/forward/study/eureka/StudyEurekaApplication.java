package com.company.forward.study.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StudyEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyEurekaApplication.class, args);
    }

}
