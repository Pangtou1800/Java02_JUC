package pt.learn.thread;

/**
 * 使用实现Runnable接口的方式买票。<br>
 */
public class WindowTest1 {
    public static void main(String[] args) {
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
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为[" + tickets + "]");
            tickets--;
        }
    }
}