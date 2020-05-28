package com.company.forward.study.rest.feign;

import org.company.forward.domain.basic.BasicErrorCode;
import org.company.forward.domain.basic.BasicResponse;
import org.springframework.stereotype.Component;

@Component
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class HystrixStudyFeignServerClientFallbackFactory implements HystrixStudyFeignServerClient {
        @Override
        public BasicResponse epAlipayBillFlow(String flowNo) {
            BasicResponse basicResponse = new BasicResponse();
            basicResponse.setErrorCode(BasicErrorCode.SERVICE_ERROR_CODE);
            basicResponse.setErrorMsg("falllback；service not avaliable!");
            return basicResponse;
        }
    }