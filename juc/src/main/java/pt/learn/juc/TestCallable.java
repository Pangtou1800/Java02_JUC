package pt.learn.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 一、创建执行线程的方式三：实现Callable接口<br>
 * 相较于实现Runnable接口的方式： 1.方法有返回值 2.可以抛出异常<br>
 * 执行Callable方式，需要FutureTask实现类的支持，用来接收运算结果。<br>
 * FutureTask是Future接口的实现类。
 */
public class TestCallable {
    public static void main(final String[] args) {
        final ThreadDemo2 td = new ThreadDemo2();

        // 1.
        final FutureTask<Integer> result = new FutureTask<>(td);
        
        new Thread(result).start();

        // 2.接收线程运算结果
        try {
            Integer sum = result.get(); // FutureTask也可用为闭锁
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class ThreadDemo2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Start");
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            sum += i;
        }

        return sum;
    }
}