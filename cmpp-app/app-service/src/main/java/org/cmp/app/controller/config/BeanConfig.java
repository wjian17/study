package org.cmp.app.controller.config;

import org.cmp.rest.remote.RestRemoteService1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangjian
 * @date: 2021/12/28 11:05
 */
@Configuration
public class BeanConfig {

    @Bean
//    @Primary
    public RestRemoteService1 test(){
        return new RestRemoteService1SelfImpl();
    }
}
