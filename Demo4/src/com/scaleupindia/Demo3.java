package com.scaleupindia;

import com.scaleupindia.service.CounterService;
import com.scaleupindia.service.impl.CounterServiceImpl2;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo3 extends Thread {
	private static final int NUM_THREADS = 2;
	private static final int NUM_INCREMENTS = 1000;
	private CounterService counterUtil;

	public Demo3(CounterService counterUtil) {
		this.counterUtil = counterUtil;
	}

	public static void main(String[] args) throws InterruptedException {
		CounterService counterUtil = null;
		do {
			Thread[] threads = new Thread[NUM_THREADS];
			counterUtil = new CounterServiceImpl2();
			for (int i = 0; i < NUM_THREADS; ++i) {
				threads[i] = new Demo3(counterUtil);
				threads[i].start();
			}
			for (int i = 0; i < NUM_THREADS; ++i) {
				threads[i].join();
			}
			System.out.println("Actual count = " + counterUtil.getCount() + " vs. Expected count = "
					+ (NUM_THREADS * NUM_INCREMENTS));
		} while (counterUtil.getCount() == (NUM_THREADS * NUM_INCREMENTS));
	}

	@Override
	public void run() {
		for (int i = 0; i < NUM_INCREMENTS; ++i) {
			counterUtil.incrementCount();
		}
	}
}
