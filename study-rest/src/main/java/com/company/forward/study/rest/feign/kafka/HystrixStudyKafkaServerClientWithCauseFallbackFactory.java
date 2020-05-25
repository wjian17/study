package com.company.forward.study.rest.feign.kafka;

import feign.hystrix.FallbackFactory;
import org.company.forward.domain.basic.BasicErrorCode;
import org.company.forward.domain.basic.BasicResponse;
import org.springframework.stereotype.Component;

@Component
public class HystrixStudyKafkaServerClientWithCauseFallbackFactory implements FallbackFactory<HystrixStudyKafkaServerClientWithCause> {
        @Override
        public HystrixStudyKafkaServerClientWithCause create(Throwable cause) {
            return new HystrixStudyKafkaServerClientWithCause() {
                @Override
                public BasicResponse send(String msg) {
//                    "fallback; reason was: " + cause.getMessage()
                    BasicResponse basicResponse = new BasicResponse();
                    basicResponse.setErrorCode(BasicErrorCode.SERVICE_ERROR_TIMEOUT);
                    basicResponse.setErrorMsg("fallback; reason was: " + cause.getMessage());
                    return basicResponse;
                }
            };
        }
    }