package com.company.forward.study.rest.feign;

import org.company.forward.domain.basic.BasicErrorCode;
import org.company.forward.domain.basic.BasicResponse;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements HystrixStudyFeignServerClient {
        @Override
        public BasicResponse iFailSometimes() {
            BasicResponse basicResponse = new BasicResponse();
            basicResponse.setErrorCode(BasicErrorCode.SERVICE_ERROR_CODE);
            basicResponse.setErrorMsg("falllback；service not avaliable!");
            return basicResponse;
        }
    }