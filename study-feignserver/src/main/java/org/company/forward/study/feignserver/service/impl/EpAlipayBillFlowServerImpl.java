package org.company.forward.study.feignserver.service.impl;

import org.company.forward.db.config.CurDataSource;
import org.company.forward.db.config.DataSourceNames;
import org.company.forward.domain.rest.EpAlipayBillFlow;
import org.company.forward.study.feignserver.config.redis.RedisUtil;
import org.company.forward.study.feignserver.mapper.EpAlipayBillFlowMapper;
import org.company.forward.study.feignserver.service.EpAlipayBillFlowServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpAlipayBillFlowServerImpl implements EpAlipayBillFlowServer {

    @Autowired
    private EpAlipayBillFlowMapper epAlipayBillFlowMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CacheManager cacheManager;

    @Override
    @CurDataSource(name = DataSourceNames.SALVER)
    public List<EpAlipayBillFlow> queryEpAlipayBillFlowList(String flowNo) {
        List<EpAlipayBillFlow> list = epAlipayBillFlowMapper.queryEpAlipayBillFlowList(flowNo);
        cacheManager.getCache("user");
        redisUtil.set(flowNo,"{'key1':'value'}");
        return list;
    }
}
