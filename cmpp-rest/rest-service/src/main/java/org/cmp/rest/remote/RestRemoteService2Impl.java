package org.cmp.rest.remote;

import org.cmp.core.resp.CmpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangjian
 * @date: 2021/12/24 17:02
 */
@RestController
public class RestRemoteService2Impl implements RestRemoteService2 {
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
