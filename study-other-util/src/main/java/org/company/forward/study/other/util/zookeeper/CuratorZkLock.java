package org.company.forward.study.other.util.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

/**
 * @author wangjian
 * @date 2020/6/3 0003 9:43
 */

public class CuratorZkLock {

    /*InterProcessMutex：分布式可重入排它锁
    InterProcessSemaphoreMutex：分布式排它锁
    InterProcessReadWriteLock：分布式读写锁
    InterProcessMultiLock：将多个锁作为单个实体管理的容器*/
    private CuratorFramework curatorFramework;

    public CuratorZkLock(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;
    }

    public void lockInshareMode(String lockPath) throws Exception {
        InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework,lockPath);
        interProcessMutex.acquire();
        interProcessMutex.release();
    }

    public static void main(String[] args) {

    }
}
