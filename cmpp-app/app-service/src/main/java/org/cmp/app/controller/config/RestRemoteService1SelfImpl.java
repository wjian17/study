package org.cmp.app.controller.config;

import org.cmp.core.resp.CmpResponse;
import org.cmp.rest.service.remote.RestRemoteService1;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author: wangjian
 * @date: 2021/12/28 11:06
 */
//@Service
//@Primary
public class RestRemoteService1SelfImpl implements RestRemoteService1 {
    @Override
    public CmpResponse service1_1() {
        return null;
    }

    @Override
    public CmpResponse service1_2() {
        return null;
    }
}
