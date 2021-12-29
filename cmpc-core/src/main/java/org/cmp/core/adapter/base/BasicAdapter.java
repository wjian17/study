package org.cmp.core.adapter.base;


import org.cmp.core.adapter.dto.DispatcherContext;

/**
 * @author: wangjian
 * @date: 2021/12/28 10:11
 */
public interface BasicAdapter<T> {

    DispatcherContext getDispatcherContext();
}
