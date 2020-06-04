package org.company.forward.study.feignserver.service.impl;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.company.forward.db.config.CurDataSource;
import org.company.forward.db.config.DataSourceNames;
import org.company.forward.domain.annotation.EnableCuratorZkLock;
import org.company.forward.domain.rest.EpAlipayBillFlow;
import org.company.forward.study.feignserver.mapper.EpAlipayBillFlowMapper;
import org.company.forward.study.feignserver.service.EpAlipayBillFlowServer;
import org.company.forward.study.other.util.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class EpAlipayBillFlowServerImpl implements EpAlipayBillFlowServer {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EpAlipayBillFlowMapper epAlipayBillFlowMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private CuratorFramework curatorFramework;

    @Override
    @CurDataSource(name = DataSourceNames.SALVER)
    @EnableCuratorZkLock(value = "#flowNo",time = 120,timeUnit = TimeUnit.SECONDS )
    public List<EpAlipayBillFlow> queryEpAlipayBillFlowList(String flowNo) {

       Stat stat = new Stat();
       try {
          List<String> list = curatorFramework.getChildren()
                  .forPath("/lock123");
          for (String node:list) {
             byte[] data = curatorFramework.getData().forPath("/lock123/"+node);
             logger.info("数据：{}",new String(data));
          }
       } catch (Exception e) {
          e.printStackTrace();
       }

       List<EpAlipayBillFlow> list = epAlipayBillFlowMapper.queryEpAlipayBillFlowList(flowNo);
//        cacheManager.getCache("user");
//        redisUtil.set(flowNo,"{'key1':'value'}");
        return list;
    }
}
