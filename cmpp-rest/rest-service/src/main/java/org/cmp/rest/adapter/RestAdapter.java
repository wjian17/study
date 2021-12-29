package org.cmp.rest.adapter;

import org.cmp.core.adapter.inf.DispatcherAdapter;
import org.cmp.core.annotation.AdapterMgr;
import org.cmp.core.adapter.base.BasicAdapter;
import org.cmp.core.resp.CmpResponse;
import org.cmp.rest.dto.RestDispatcher;

import java.util.Map;

/**
 * @author: wangjian
 * @date: 2021/12/28 9:47
 */
@AdapterMgr
public interface RestAdapter extends BasicAdapter<RestDispatcher>, DispatcherAdapter {

    CmpResponse test(RestDispatcher restDispatcher);
}
