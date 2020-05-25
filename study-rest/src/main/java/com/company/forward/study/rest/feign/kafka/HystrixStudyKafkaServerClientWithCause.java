package com.company.forward.study.rest.feign.kafka;


import org.company.forward.domain.basic.BasicResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "study-kafka", fallbackFactory = HystrixStudyKafkaServerClientWithCauseFallbackFactory.class)
public interface HystrixStudyKafkaServerClientWithCause {

    @RequestMapping(value = "send/{msg}", method = RequestMethod.POST)
    BasicResponse send(@PathVariable String msg);

}

