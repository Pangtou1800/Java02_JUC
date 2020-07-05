package pt.learn.juc;

/**
 * 一、volatile关键字：当多个线程操作共享数据时，可以保证内存中的数据可见。可以理解为变量操作都是在主存中完成的。
 * 		相较于synchronized是一种较为轻量级的同步策略。
 * 
 * 注意：
 * 1.volatile不具备互斥性
 * 2.volatile不能保证变量的原子性
 * */

public class TestVolatile {
	public static void main(String[] args) {
		ThreadDemo ts= new ThreadDemo();
		new Thread(ts).start();
		
		// hell
//		while(true) {
//			if (ts.isFlag()) {
//				System.out.println("----------");
//				break;
//			}
//		}
		
//		while (true) {
//			// 同步锁保证每次内存缓存刷新，然而效率低
//			synchronized (ts) {
//				if (ts.isFlag()) {
//					System.out.println("----------");
//					break;
//				}
//			}
//		}
		
		while (true) {
			if (ts.isFlag()) {
				System.out.println("----------");
				break;
			}
		}
	}
}

class ThreadDemo implements Runnable {

	// private boolean flag = false;
	
	private volatile boolean flag = false;

	@Override
	public void run() {

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			;
		}

		flag = true;

		System.out.println("flag=" + isFlag());
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
