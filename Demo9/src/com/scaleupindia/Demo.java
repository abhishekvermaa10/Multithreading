package com.scaleupindia;

import com.scaleupindia.service.CounterService;
import com.scaleupindia.service.impl.CounterServiceImpl;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo extends Thread {
	private static final int NUM_THREADS = 2;
	private static final int NUM_INCREMENTS = 10;
	private CounterService counterService;

	public Demo(CounterService counterService) {
		this.counterService = counterService;
	}

	public static void main(String[] args) throws InterruptedException {
		CounterService counterService = null;
		Thread[] threads = new Thread[NUM_THREADS];
		counterService = new CounterServiceImpl();
		for (int i = 0; i < NUM_THREADS; ++i) {
			threads[i] = new Demo(counterService);
			threads[i].start();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < NUM_INCREMENTS; ++i) {
			counterService.incrementCount();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}