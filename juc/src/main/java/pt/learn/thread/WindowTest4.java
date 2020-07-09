package pt.learn.thread;

public class WindowTest4 {
    public static void main(String[] args) {
        Window41 window1 = new Window41();
        window1.setName("窗口1");
        Window41 window2 = new Window41();
        window2.setName("窗口2");
        Window41 window3 = new Window41();
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}

class Window41 extends Thread {

    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if (!sellTicket()) {
                break;
            }
        }
    }

    private static synchronized boolean sellTicket() {
        if (tickets > 0) {
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 卖票[" + tickets + "]");
            tickets--;
            return true;
        } else {
            return false;
        }
    }
}