package org.cmp.rest.remote;

import org.cmp.core.resp.CmpResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: wangjian
 * @date: 2021/12/24 16:31
 */

@FeignClient(name = "rest", path = "/rest",contextId = "RestRemoteService2")
public interface RestRemoteService2 {

    @PostMapping("/service2_1")
    CmpResponse service2_1();

    @PostMapping("/service2_1")
    CmpResponse service2_2();
}
