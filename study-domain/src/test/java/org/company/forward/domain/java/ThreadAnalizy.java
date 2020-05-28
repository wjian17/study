package org.company.forward.domain.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class ThreadAnalizy {

    public static void main(String[] args) throws Exception {

//        new ThreadAnalizy().newFixedThreadPool();
        new ThreadAnalizy().newCachedThreadPool();
    }

//    @Test
    public void testSleep(){
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000l);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000l);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000l);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000l);
                System.out.println(Thread.currentThread().getName());
            }catch (Exception e){

            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000l);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000l);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000l);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000l);
                System.out.println(Thread.currentThread().getName());
            }catch (Exception e){

            }
        }).start();
    }


//    @Test
    public void newCachedThreadPool() throws Exception{
        ThreadPoolExecutor newCachedThreadPool = (ThreadPoolExecutor)Executors.newCachedThreadPool();
//        ThreadPoolExecutor newSingleThreadExecutor = (ThreadPoolExecutor)Executors.newSingleThreadExecutor();
        List<Thread> threads = new ArrayList<>();
        for(int i=0;i<100;i++){
            System.out.println(i);
            Thread thread = new Thread(()->{
                String name = Thread.currentThread().getName();
//                System.out.println("当前执行线程："+name);
                System.out.println("当前执行线程：start=="+name+"::::::"+newCachedThreadPool.getQueue().size());
                try {
                    Thread.sleep(3000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("当前执行线程：end=="+name+"::::::"+newCachedThreadPool.getQueue().size());
                }
                System.out.println("当前执行线程：end=="+name+"::::::"+newCachedThreadPool.getQueue().size());
            });
            threads.add(thread);
        }
        for(int i=0;i<100;i++){
//            newCachedThreadPool.submit(new ThreadCallable());
//            newCachedThreadPool.submit(threads.get(i));
//            newCachedThreadPool.execute(threads.get(i));
        }
        for (Thread thread:threads) {
//            Future future = newCachedThreadPool.submit(thread);
            newCachedThreadPool.execute(thread);
        }
        newCachedThreadPool.shutdown();
    }
//    @Test
    public void newFixedThreadPool() throws Exception{
        ThreadPoolExecutor newFixedThreadPool = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
//        ThreadPoolExecutor newSingleThreadExecutor = (ThreadPoolExecutor)Executors.newSingleThreadExecutor();

        Collection<ThreadCallable> threads = new ArrayList<>();
        for(int i=0;i<100;i++){
            System.out.println(i);
            ThreadCallable thread = new ThreadCallable();
            threads.add(thread);
        }
        newFixedThreadPool.invokeAll(threads);


//        newCachedThreadPool.shutdown();
    }


    class ThreadCallable implements Callable<Object> {

        @Override
        public Object call() throws Exception {
            Thread name = Thread.currentThread();
//                System.out.println("当前执行线程："+name);
            System.out.println("当前执行线程：start==" + name + "::::::");
            try {
                Thread.sleep(3000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return e;
            }
            System.out.println("===========当前执行线程：end==" + name + "::::::");
            return null;
        }
    }
}
