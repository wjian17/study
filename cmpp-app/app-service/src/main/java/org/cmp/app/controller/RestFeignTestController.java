package org.cmp.app.controller;

import org.cmp.core.resp.CmpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.cmp.rest.remote.RestRemoteService1;
import org.cmp.rest.remote.RestRemoteService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangjian
 * @date: 2021/12/24 17:18
 */
@RestController
@Api(value = "rest feign测试",tags = "rest feign测试")
public class RestFeignTestController {

    @Autowired
    private RestRemoteService1 restRemoteService1;

    @Autowired
    private RestRemoteService2 restRemoteService2;

    @PostMapping("/testServer1")
    @ApiOperation("测试：testServer1")
    public CmpResponse testServer1(){
        return restRemoteService1.service1_1();
    }

    @PostMapping("/testServer2")
    @ApiOperation("测试：testServer2")
    public CmpResponse testServer2(){
        return restRemoteService2.service2_1();
    }
}
