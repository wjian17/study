package org.cmp.rest.controller;

import cn.hutool.core.map.MapUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.cmp.app.remote.AppRemoteService1;
import org.cmp.app.remote.AppRemoteService2;
import org.cmp.core.resp.CmpResponse;
import org.cmp.rest.adapter.RestAdapter;
import org.cmp.rest.dto.RestDispatcher;
import org.cmp.rest.service.remote.RestRemoteService1;
import org.cmp.rest.service.remote.RestRemoteService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangjian
 * @date: 2021/12/24 17:18
 */
@Slf4j
@RestController
@Api(value = "app feign测试",tags = "app feign测试")
public class AppFeignTestController {

    @Autowired
    private AppRemoteService1 appRemoteService1;

    @Autowired
    private AppRemoteService2 appRemoteService2;

    @Autowired
    private RestAdapter restAdapter;

    @PostMapping("/testServer1")
    @ApiOperation("测试：testServer1")
    public CmpResponse testServer1(){
        log.info("测试 rest服务 调用 api服务");
        return appRemoteService1.service1_1();
    }

    @PostMapping("/testServer2")
    @ApiOperation("测试：testServer2")
    public CmpResponse testServer2(){
        return appRemoteService2.service2_1();
    }

    @PostMapping("/testServer3")
    @ApiOperation("测试：testServer3")
    public CmpResponse testServer3(@RequestBody RestDispatcher restDispatcher){
        return restAdapter.test(restDispatcher);
    }
}
