package org.company.forward.study.quartz.service.impl;

import org.company.forward.db.config.CurDataSource;
import org.company.forward.db.config.DataSourceNames;
import org.company.forward.domain.rest.EpAlipayBillFlow;
import org.company.forward.study.quartz.mapper.EpAlipayBillFlowMapper;
import org.company.forward.study.quartz.service.EpAlipayBillFlowServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class EpAlipayBillFlowServerImpl implements EpAlipayBillFlowServer {

    @Autowired
    private EpAlipayBillFlowMapper epAlipayBillFlowMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    @CurDataSource(name = DataSourceNames.SALVER)
    public List<EpAlipayBillFlow> queryEpAlipayBillFlowList(String flowNo) {
        List<EpAlipayBillFlow> list = epAlipayBillFlowMapper.queryEpAlipayBillFlowList(flowNo);
        return list;
    }
}
