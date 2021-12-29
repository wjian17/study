package org.cmp.app.controller.service.remote;

import org.cmp.app.remote.AppRemoteService2;
import org.cmp.core.resp.CmpResponse;
import org.cmp.rest.service.remote.RestRemoteService2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangjian
 * @date: 2021/12/24 17:02
 */
@RestController
public class AppRemoteService2Impl implements AppRemoteService2 {
    @Override
    @PostMapping("/service2_1")
    public CmpResponse service2_1() {
        return null;
    }

    @Override
    @PostMapping("/service2_2")
    public CmpResponse service2_2() {
        return null;
    }
}
