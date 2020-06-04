package com.company.forward.study.rest.feign;

import feign.hystrix.FallbackFactory;
import org.company.forward.domain.enums.BasicErrorCode;
import org.company.forward.domain.basic.BasicResponse;
import org.springframework.stereotype.Component;

@Component
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class HystrixStudyFeignServerClientWithCauseFallbackFactory implements FallbackFactory<HystrixStudyFeignServerClientWithCause> {
        @Override
        public HystrixStudyFeignServerClientWithCause create(Throwable cause) {
            return new HystrixStudyFeignServerClientWithCause() {
                @Override
                public BasicResponse epAlipayBillFlow(String flowNo) {
//                    "fallback; reason was: " + cause.getMessage()
                    BasicResponse basicResponse = new BasicResponse();
                    basicResponse.setErrorCode(BasicErrorCode.SERVICE_ERROR_TIMEOUT_CODE);
                    basicResponse.setErrorMsg("fallback; reason was: " + cause.getMessage());
                    return basicResponse;
                }
            };
        }
    }