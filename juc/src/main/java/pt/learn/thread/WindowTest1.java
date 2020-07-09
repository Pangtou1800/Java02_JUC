package pt.learn.thread;

/**
 * 使用实现Runnable接口的方式买票。<br>
 * 1. 卖票过程中出现了重票和错票 --> 线程安全问题<br>
 * 2. 问题出现的原因：当某个线程在操作车票的过程中尚未操作完成时，其他线程参与进来，也操作车票<br>
 * 3. 如何解决：当一个线程A在操作票的时候，其它线程不能参与进来。直到线程A操作完成，其他线程才可以加入<br>
 * 这种情况即使线程A出现了阻塞，也不能被改变<br>
 * 4. 在Java中，通过同步机制来解决线程安全问题<br>
 * 
 * Jdk最初提供的两种方式：<br>
 * 方式一：同步代码块 <br>
 * synchronized(同步监视器) { 需要被同步的代码 } <br>
 * 说明：1.操作共享数据的代码即为需要被同步的代码<br>
 *      2.共享数据：多个线程共同操作的变量。比如tickets就是共享数据<br>
 *      3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁<br>
 *        隐式要求：多个线程必须公用同一把锁。<br>
 * 
 * 5. 同步的方式解决了线程安全问题。 ---好处<br>
 *    操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。---坏处<br>
 * 
 * 方式二：同步方法 <br>
 *  如果操作共享数据的代码完整地声明在一个方法中，不妨将此方法声明为同步方法。<br>
 */
public class WindowTest1 {

    public static void main(String[] args) {
        Window3 window3 = new Window3();

        Thread t1 = new Thread(window3, "窗口1");
        Thread t2 = new Thread(window3, "窗口2");
        Thread t3 = new Thread(window3, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

    public static void main2(String[] args) {
        Window2 window2 = new Window2();

        Thread t1 = new Thread(window2, "窗口1");
        Thread t2 = new Thread(window2, "窗口2");
        Thread t3 = new Thread(window2, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

    public static void main1(String[] args) {
        Window1 window1 = new Window1();

        Thread t1 = new Thread(window1, "窗口1");
        Thread t2 = new Thread(window1, "窗口2");
        Thread t3 = new Thread(window1, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window1 implements Runnable {

    private int tickets = 100;

    @Override
    public void run() {
        while (tickets > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为[" + tickets + "]");
            tickets--;
        }
    }
}

class Window2 implements Runnable {

    private int tickets = 100;

    Dog dog = new Dog();

    @Override
    public void run() {

        while (true) {
            synchronized (dog) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为[" + tickets + "]");
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}

class Dog {}

class Window3 implements Runnable {

    private int tickets = 100;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为[" + tickets + "]");
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}