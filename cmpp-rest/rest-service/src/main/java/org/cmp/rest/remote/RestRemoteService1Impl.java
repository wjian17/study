package org.cmp.rest.remote;

import org.cmp.core.resp.CmpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangjian
 * @date: 2021/12/24 17:02
 */
@Slf4j
@RestController
public class RestRemoteService1Impl implements RestRemoteService1 {
    @Override
    @PostMapping("/service1_1")
    public CmpResponse service1_1() {
        return null;
    }

    @Override
    @PostMapping("/service1_2")
    public CmpResponse service1_2() {
        return null;
    }
}
