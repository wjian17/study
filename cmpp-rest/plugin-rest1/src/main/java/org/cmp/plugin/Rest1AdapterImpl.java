package org.cmp.plugin;

import org.cmp.core.adapter.dto.DispatcherContext;
import org.cmp.core.resp.CmpResponse;
import org.cmp.rest.adapter.RestAdapter;
import org.cmp.rest.dto.RestDispatcher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: wangjian
 * @date: 2021/12/28 10:25
 */
@Service
//@Primary
public class Rest1AdapterImpl implements RestAdapter {

    @Override
    public CmpResponse test(Map map) {
        return null;
    }

    @Override
    public DispatcherContext getDispatcherContext() {
        DispatcherContext dispatcherContext = new DispatcherContext("1");
        return dispatcherContext;
    }
}
