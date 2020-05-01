package com.company.forward.study.rest.feign;

import feign.hystrix.FallbackFactory;
import org.company.forward.domain.basic.BasicErrorCode;
import org.company.forward.domain.basic.BasicResponse;
import org.springframework.stereotype.Component;

@Component
public class HystrixStudyFeignServerClientWithCauseFallbackFactory implements FallbackFactory<HystrixStudyFeignServerClientWithCause> {
        @Override
        public HystrixStudyFeignServerClientWithCause create(Throwable cause) {
            return new HystrixStudyFeignServerClientWithCause() {
                @Override
                public BasicResponse iFailSometimes() {
//                    "fallback; reason was: " + cause.getMessage()
                    BasicResponse basicResponse = new BasicResponse();
                    basicResponse.setErrorCode(BasicErrorCode.SERVICE_ERROR_TIMEOUT);
                    basicResponse.setErrorMsg("fallback; reason was: " + cause.getMessage());
                    return basicResponse;
                }
            };
        }
    }