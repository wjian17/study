package com.company.forward.study.rest.feign.kafka;


import org.company.forward.domain.basic.BasicResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "study-kafka", path = "study-kafka",fallbackFactory = HystrixStudyKafkaServerClientWithCauseFallbackFactory.class)
public interface HystrixStudyKafkaServerClientWithCause {

    @RequestMapping(value = "send/{msg}")
    BasicResponse send(@PathVariable String msg);

    @RequestMapping(value = "feignSend")
    BasicResponse feignSend(String msg);


}

