package org.cmp.app.controller.service.remote;

import lombok.extern.slf4j.Slf4j;
import org.cmp.app.remote.AppRemoteService1;
import org.cmp.core.resp.CmpResponse;
import org.cmp.rest.service.remote.RestRemoteService1;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangjian
 * @date: 2021/12/24 17:02
 */
@Slf4j
@RestController
public class AppRemoteService1Impl implements AppRemoteService1 {
    @Override
    @PostMapping("/service1_1")
    public CmpResponse service1_1() {
        log.info("测试 fegin 调用 api服务");
        return null;
    }

    @Override
    @PostMapping("/service1_2")
    public CmpResponse service1_2() {
        return null;
    }
}
