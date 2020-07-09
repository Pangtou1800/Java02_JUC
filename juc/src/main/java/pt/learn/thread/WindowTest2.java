package pt.learn.thread;

public class WindowTest2 {
    public static void main(String[] args) {
        Window22 window1 = new Window22();
        window1.setName("窗口1");
        Window22 window2 = new Window22();
        window2.setName("窗口2");
        Window22 window3 = new Window22();
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}

class Window22 extends Thread {

    private static int tickets = 100;

    private static Dog dog = new Dog();

    @Override
    public void run() {
        while (true) {
            synchronized (dog) {
                if (tickets > 0) {
                    try {
                        sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ": 卖票[" + tickets + "]");
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}

class Window23 extends Thread {

    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (Window23.class) {
                if (tickets > 0) {
                    try {
                        sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ": 卖票[" + tickets + "]");
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}
