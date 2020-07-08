package pt.learn.thread;

/**
 * 创建多线程的方式二：实现Runnable接口<br>
 * 1. 创建一个实现了Runnable接口的类<br>
 * 2. 实现类实装Runnable的抽象方法run()<br>
 * 3. 创建实现类的对象<br>
 * 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象<br>
 * 5. 通过Thread类的对象调用start()<br>
 * 
 * <p>
 * 比较创建线程的两种方式:<br>
 * 开发中优先选择实现Runnable接口的方式。<br>
 * 原因1：没有类的单继承的局限性<br>
 * 原因2：更适合来处理多个线程共享数据的情况。<br>
 * 
 * 联系：<br>
 * public class Thread implements Runnable ~ <br>
 * 相同点：两种方法都需要重写run()，将线程要执行的逻辑声明在run()中。<br>
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        MThread mt = new MThread();
        Thread thread = new Thread(mt);
        thread.setName("线程1");
        thread.start();

        Thread thread2 = new Thread(mt);
        thread2.setName("线程2");
        thread2.start();

    }
}

class MThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": [" + i + "]");
            }
        }
    }
}