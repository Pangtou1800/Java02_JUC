package pt.learn.thread;

/**
 * 创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数<br>
 */

public class ThreadDemo {
    public static void main(String[] args) {
        EvenIterator even = new EvenIterator();
        OddIterator odd = new OddIterator();
        even.start();
        odd.start();

        // 创建Thread类的匿名子类
        (new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "[" + i + "]");
                    }
                }
            }
        }).start();

        (new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "[" + i + "]");
                    }
                }
            }
        }).start();
    }
}

class EvenIterator extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "[" + i + "]");
            }
        }
    }
}

class OddIterator extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "[" + i + "]");
            }
        }
    }
}