package org.company.forward.study.other.util.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author wangjian
 * @date 2020/6/2 0002 17:01
 */
@Configuration
public class CuratorZkConfig {

    @Autowired
    private Environment env;

    @Bean("curatorFramework")
    public CuratorFramework getCuratorFramework() {

        /**
         * 同步创建zk示例，原生api是异步的
         * curator连接zk的策略：ExponentialBackoffRetry
         *
         * ExponentialBackoffRetry(int baseSleepTimeMs, int maxRetries)
         *  baseSleepTimeMs：初始sleep的时间
         *  maxRetries：最大重试次数
         *  maxSleepMs：最大充实实际那
         */
        RetryPolicy retryPolicy1 = new ExponentialBackoffRetry(1000, 3);

        /**
         * curator连接zk的策略：RetryNTimes
         *
         * RetryNTimes(int n, int sleepMsBetweenRetries)
         *  n:重试的次数
         *  sleepMsBetweenRetries：每次重试的间隔的时间
         */
        RetryPolicy retryPolicy2 = new RetryNTimes(3, 5000);

        /**
         * curator连接zk的策略：RetryOneTime
         *
         * RetryOneTime(int sleepMsBetweenRetry)
         * sleepMsBetweenRetry：每次重试间隔的时间
         */
        RetryPolicy retryPolicy3 = new RetryOneTime(3000);

        /**
         * curator连接zk的策略：RetryForever
         *
         *  RetryForever(int retryIntervalMs)
         *  永远重试，不推荐
         */
        RetryPolicy retryPolicy4 = new RetryForever(5000);

        /**
         * curator连接zk的策略：RetryUntilElapsed
         *
         * RetryUntilElapsed(int maxElapsedTimeMs, int sleepMsBetweenRetries)
         * maxElapsedTimeMs：最大重试时间
         * sleepMsBetweenRetries：每次重试间隔
         * 重试时间超过maxElapsedTimeMs后，就不在重试
         */
        RetryPolicy retryPolicy5 = new RetryUntilElapsed(2000, 3000);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(env.getProperty("curator.zookeeper.zkServerPath"))
                .sessionTimeoutMs(10000)
                .retryPolicy(retryPolicy2)
                .namespace("workspace")
                .build();
        client.start();
        return client;
    }

    @Bean
    public CuratorZkLock getCuratorZkLock(@Qualifier(value = "curatorFramework") CuratorFramework curatorFramework){
        return new CuratorZkLock(curatorFramework);
    }

}
