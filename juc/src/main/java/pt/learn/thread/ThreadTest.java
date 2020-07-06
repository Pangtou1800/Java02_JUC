package pt.learn.thread;

/**
 * 多线程的创建，方式一：继承于Thread类<br>
 * 1.创建一个继承于Thread类的子类<br>
 * 2.重写Thread类的run()<br>
 * 3.创建Thread类的子类的对象<br>
 * 4.通过此对象调用Thread类的start()<br>
 * <p>
 * 例子：遍历100以内的所有偶数
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.run();
        // start()的两个作用：
        // ①启动当前线程
        // ②调用run()
        // 问题一：不能通过直接调用run()的方式启动线程
        // 问题二：不能让已经start()的线程再次启动
        System.out.println("Hello");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + "[" + i + "]");
        }
    }
}