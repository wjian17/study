package org.company.forward.study.quartz.task;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangjian
 * @date 2020/6/4 0004 14:05
 */
@Component
public class LockTestTask {

    private AtomicInteger atomicInteger;

    private ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<>();

    private volatile int count;

    private CountDownLatch countDownLatch = new CountDownLatch(100);

    @Autowired
    private CuratorFramework curatorFramework;

    @Scheduled(fixedRate = 1000)
    public void LockTestTask() throws Exception {

        InterProcessMutex interProcessMutex = null;
        try {
            simpleDateFormatThreadLocal.set(new SimpleDateFormat("yyyyMMdd HHmmss"));
            interProcessMutex = new InterProcessMutex(curatorFramework,"/TLOCK/LK");
            System.out.println("================================================");
            System.out.println("================================================");
            boolean bool = interProcessMutex.acquire(6, TimeUnit.SECONDS);
            if(bool){
                System.out.println("加锁系统时间"+simpleDateFormatThreadLocal.get().format(System.currentTimeMillis())+this);
//                System.out.println(Thread.currentThread().getName()+":"+countDownLatch);
//                System.out.println(Thread.currentThread().getName()+":"+count);
//                System.out.println(Thread.currentThread().getName()+":"+atomicInteger.toString());
                logger();
            }else{
                System.out.println("争夺失败系统时间"+simpleDateFormatThreadLocal.get().format(System.currentTimeMillis())+this);
            }
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName()+"::::::::"+e.getMessage());
        } finally {
            if(interProcessMutex!=null){
//                interProcessMutex.release();
            }
        }
    }


    public void logger() throws InterruptedException {
//        System.out.println(Thread.currentThread().getName()+":"+countDownLatch);
//        System.out.println(Thread.currentThread().getName()+":"+count);
//        System.out.println(Thread.currentThread().getName()+":"+atomicInteger.toString());
        Thread.sleep(5000);
        System.out.println("======================end========================");
        System.out.println("======================end========================");
//        atomicInteger.addAndGet(1);
//        count++;
//        countDownLatch.countDown();

    }

    @Scheduled(cron = "0 30 11 ? * *")
    public void fixTimeExecution() {
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
    }
}
