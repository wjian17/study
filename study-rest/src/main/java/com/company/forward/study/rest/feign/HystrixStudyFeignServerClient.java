package com.company.forward.study.rest.feign;

import org.company.forward.domain.basic.BasicErrorCode;
import org.company.forward.domain.basic.BasicResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "study-feignserver",fallback = HystrixClientFallback.class)
public interface HystrixStudyFeignServerClient {

    @RequestMapping(value = "EpAlipayBillFlow", method = RequestMethod.POST)
    BasicResponse iFailSometimes();


}

