package pt.learn.thread;

/**
 * 测试Thread中的常用方法<br>
 * 1. start():启动当前线程，调用当前线程的run()<br>
 * 2. run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中<br>
 * 3. currentThread():静态方法，返回执行当前代码的线程<br>
 * 4. getName():获取线程的名字<br>
 * 5. setName():设置线程的名字<br>
 * 6. yield():释放当前CPU的执行权<br>
 * 7. join():在线程A中调用线程B的join方法，此时线程A进入阻塞状态，直到线程B完全执行完毕，线程A才结束阻塞状态。<br>
 * 8. stop():已过时。当执行此方法时，强制结束当前线程。<br>
 * 9. sleep(long
 * millitime):让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态。<br>
 * 10. isAlive(): 判断当前线程是否存活。<br>
 * 
 * <h3>线程的优先级</h3> 1.<br>
 * MAX_PIROTITY: 10<br>
 * MIN_PRIOTIRY: 1<br>
 * NORM_PRIOTIRY: 5<br>
 * 2.如何获取和设置当前线程的优先级<br>
 * getPriority():获取当前线程的优先级<br>
 * setPriority():设置当前线程的优先级<br>
 * 说明：高优先级线程抢占低优先级线程CPU的执行权，但只是从概率上来讲比较高。并不意味着只有当高优先级的线程执行完成后低优先级的线程才会执行。
 */

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread ht = new HelloThread();
        ht.setName("线程1");
        ht.setPriority(Thread.MAX_PRIORITY);
        ht.start();

        // 给主线程一个名字
        Thread.currentThread().setName("主线程");

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(
                        Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":[" + i + "]");
            }
            // if (i == 20) {
            // try {
            // ht.join();
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
            // }
        }

        System.out.println(ht.isAlive());
    }
}

class HelloThread extends Thread {

    public HelloThread() {
        super();
    }

    public HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                // try {
                // sleep(20);
                // } catch (InterruptedException e) {
                // e.printStackTrace();
                // }
                System.out.println(
                        Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":[" + i + "]");
            }
            // if (i % 20 == 0) {
            // yield();
            // }
        }
    }
}