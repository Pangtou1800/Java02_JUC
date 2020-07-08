package pt.learn.thread;

/**
 * 例子：创建三个窗口买票，总票数为100张。<br>
 * 使用继承Thread类的方式实现。<br>
 * 存在线程的安全问题，待解决。<br>
 */
public class WindowTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        window1.setName("窗口1");
        Window window2 = new Window();
        window2.setName("窗口2");
        Window window3 = new Window();
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}

class Window extends Thread {

    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(getName() + ": 卖票[" + tickets + "]");
                tickets--;
            } else {
                break;
            }

        }
    }
}