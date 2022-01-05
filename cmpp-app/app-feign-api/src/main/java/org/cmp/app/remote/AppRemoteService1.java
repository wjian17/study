package org.cmp.app.remote;

import io.swagger.annotations.ApiOperation;
import org.cmp.core.resp.CmpResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: wangjian
 * @date: 2021/12/24 16:31
 */

@FeignClient(name = "app", path = "/app", contextId = "AppRemoteService1",configuration = FeignClientsConfiguration.class)
public interface AppRemoteService1 {

    @PostMapping("/service1_1")
    CmpResponse service1_1();

    @PostMapping("/service2_1")
    CmpResponse service1_2();
}
