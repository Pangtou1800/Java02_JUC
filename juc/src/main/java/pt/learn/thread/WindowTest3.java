package pt.learn.thread;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 * 
 * 关于同步方法的总结：
 *  1. 同步方法任然涉及到同步监视器，只是不需要显式声明
 *  2. 非静态的同步方法，同步监视器是this；静态的同步方法，同步监视器是当前类的class
 */
public class WindowTest3 {
    public static void main(String[] args) {
        Window31 window = new Window31();

        Thread t1 = new Thread(window, "窗口1");
        Thread t2 = new Thread(window, "窗口2");
        Thread t3 = new Thread(window, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window31 implements Runnable {

    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if (!sellTicket()) {
                break;
            }
        }
    }

    public synchronized boolean sellTicket() {
        if (tickets > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为[" + tickets + "]");
            tickets--;
            return true;
        } else {
            return false;
        }
    }
}