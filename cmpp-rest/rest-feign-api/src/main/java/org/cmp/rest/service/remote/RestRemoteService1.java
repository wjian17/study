package org.cmp.rest.service.remote;

import org.cmp.core.resp.CmpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: wangjian
 * @date: 2021/12/24 16:31
 */

@FeignClient(name = "rest", path = "/rest",contextId = "RestRemoteService1")
public interface RestRemoteService1 {

    @PostMapping("/service1_1")
    CmpResponse service1_1();

    @PostMapping("/service1_2")
    CmpResponse service1_2();
}
