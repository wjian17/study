package org.company.forward.domain.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangjian
 * @date 2020/5/29 0029 16:44
 */
public class ThreadLocalAnalizy {

    static ThreadLocal<CollectionAnalizy> staticCollectionAnalizyThreadLocal = new ThreadLocal<>();

    protected ThreadLocal<CollectionAnalizy> collectionAnalizyThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        ExecutorService newCachedThreadPool =  Executors.newCachedThreadPool();
        int i = 0;
        for(i=0;i<100;i++) {
            newCachedThreadPool.submit(() -> {
                CollectionAnalizy collectionAnalizy = new CollectionAnalizy();
                collectionAnalizy.setAnalizy(Thread.currentThread().toString());
                ThreadLocalAnalizy.staticCollectionAnalizyThreadLocal.set(collectionAnalizy);
                System.out.println(ThreadLocalAnalizy.staticCollectionAnalizyThreadLocal.get()+"||||"+Thread.currentThread().toString());
                Thread.sleep(5);
                System.out.println(ThreadLocalAnalizy.staticCollectionAnalizyThreadLocal.get()+"===="+Thread.currentThread().toString());
                Thread.sleep(5000);
                return null;
            });
        }

    }
}
