//package org.company.forward.study.util.lock;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//
///**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class LockUtil {
//
//    private String currentPath;
//
//
//
//    /**
//     * 尝试加锁
//     *
//     * @return
//     */
//    @Override
//    public boolean tryLock() {
//        // 创建临时顺序节点
//        if (this.currentPath == null) {
//            // 在lockPath节点下面创建临时顺序节点
//            currentPath = this.client.createEphemeralSequential(LockPath + "/", "aaa");
//        }
//        // 获得所有的子节点
//        List<String> children = this.client.getChildren(LockPath);
//
//        // 排序list
//        Collections.sort(children);
//
//        // 判断当前节点是否是最小的,如果是最小的节点,则表明此这个client可以获取锁
//        if (currentPath.equals(LockPath + "/" + children.get(0))) {
//            return true;
//        } else {
//            // 如果不是当前最小的sequence,取到前一个临时节点
//            // 1.单独获取临时节点的顺序号
//            // 2.查找这个顺序号在children中的下标
//            // 3.存储前一个节点的完整路径
//            int curIndex = children.indexOf(currentPath.substring(LockPath.length() + 1));
//            beforePath = LockPath + "/" + children.get(curIndex - 1);
//        }
//        return false;
//    }
//
//    private void waitForLock() {
//        CountDownLatch cdl = new CountDownLatch(1);
//        // 注册watcher
//        IZkDataListener listener = new IZkDataListener() {
//            @Override
//            public void handleDataDeleted(String dataPath) throws Exception {
//                System.out.println("监听到前一个节点被删除了");
//                cdl.countDown();
//            }
//            @Override
//            public void handleDataChange(String dataPath, Object data) throws Exception {
//            }
//        };
//
//        // 监听前一个临时节点
//        client.subscribeDataChanges(this.beforePath, listener);
//
//        // 前一个节点还存在,则阻塞自己
//        if (this.client.exists(this.beforePath)) {
//            try {
//                // 直至前一个节点释放锁,才会继续往下执行
//                cdl.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // 醒来后,表明前一个临时节点已经被删除,此时客户端可以获取锁 && 取消watcher监听
//        client.unsubscribeDataChanges(this.beforePath, listener);
//    }
//}
