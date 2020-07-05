package pt.learn.juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch:闭锁，在完成某些运算时，只有当其他所有线程的运算全部完成时，当前的运算才会执行。
 */

public class TestCountDownLatch {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(5);
		LatchDemo ld = new LatchDemo(latch);

		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 5; i++) {
			new Thread(ld).start();
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long duration = System.currentTimeMillis() - start;
		System.out.println("耗费时间为：" + duration);
	}
}

class LatchDemo implements Runnable {

	private CountDownLatch latch;

	public LatchDemo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 50000; i++) {
				if (i % 2 == 0) {
					System.out.println(i);
				}
			}
		} finally {
			latch.countDown();
		}
	}

}
