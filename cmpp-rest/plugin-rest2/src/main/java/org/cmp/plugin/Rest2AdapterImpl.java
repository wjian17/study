package org.cmp.plugin;

import org.cmp.core.adapter.dto.DispatcherContext;
import org.cmp.core.resp.CmpResponse;
import org.cmp.rest.adapter.RestAdapter;
import org.cmp.rest.dto.RestDispatcher;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: wangjian
 * @date: 2021/12/28 10:25
 */
@Service
public class Rest2AdapterImpl implements RestAdapter {

    @Override
    public DispatcherContext getDispatcherContext() {
        DispatcherContext dispatcherContext = new DispatcherContext("2");
        return dispatcherContext;
    }

    @Override
    public CmpResponse test(Map map) {
        return null;
    }
}
