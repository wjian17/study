package org.cmp.plugin;

import cn.hutool.json.JSONUtil;
import org.cmp.core.adapter.dto.DispatcherContext;
import org.cmp.core.resp.CmpResponse;
import org.cmp.core.resp.GetCmpResponse;
import org.cmp.rest.adapter.RestAdapter;
import org.cmp.rest.dto.RestDispatcher;
import org.springframework.stereotype.Service;

/**
 * @author: wangjian
 * @date: 2021/12/28 10:25
 */
@Service
//@Primary
public class Rest1AdapterImpl implements RestAdapter {

    @Override
    public CmpResponse test(RestDispatcher restDispatcher) {
        return new GetCmpResponse<String>(JSONUtil.toJsonStr(getDispatcherContext()));
    }

    @Override
    public DispatcherContext getDispatcherContext() {
        DispatcherContext dispatcherContext = new DispatcherContext("V1.0","plugn1");
        return dispatcherContext;
    }
}
