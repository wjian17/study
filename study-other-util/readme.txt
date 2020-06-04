利用zookeeper允许客户端创建一个有序的目录的特性，可以实现一个可靠的分布式共享锁。

分布式进程在读写一个共享数据时，可以先在某个公共目录下创建一个有序子目录，然后判断该目录id是否最小。
目录id最小则获得锁并消费共享数据，然后删除该目录。否则则等待(添加监听上一个节点删除状态)，直到自己的目录id成为最小后，才获得锁。

zookeeper所有目录操作事件都可以注册监听器，所以分布式进程不必循环查询子目录判断自己的目录id是否最小，可以注册一个监听器在前一个目录上，监听前一个目录是否被删除。



Curator包含6部分，均可提供单独jar包，每个包简单介绍如下：
　　client：zk-client的替代品，提供一些底层处理跟工具类；
　　framework：高级封装，大大简化了zk的客户端编程，包含对zk的连接管理，重试机制等；
　　repices：提供了一些常用的操作，比如持续监听，锁，选举等；
　　utilities：各种工具类；
　　errors：curator对异常跟错误的处理；
　　extendsion：扩展包；

<dependency>  
    <groupId>org.apache.curator</groupId>  
    <artifactId>curator-recipes</artifactId>  
    <version>2.5.0</version>  
</dependency>


InterProcessMutex：分布式可重入排它锁
InterProcessSemaphoreMutex：分布式排它锁
InterProcessReadWriteLock：分布式读写锁
InterProcessMultiLock：将多个锁作为单个实体管理的容器