package com.company.forward.study.rest.feign;


import org.company.forward.domain.basic.BasicResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "study-feignserver1", fallbackFactory = HystrixStudyFeignServerClientWithCauseFallbackFactory.class)
public interface HystrixStudyFeignServerClientWithCause {

    @RequestMapping(value = "EpAlipayBillFlow", method = RequestMethod.POST)
    BasicResponse iFailSometimes();

}

