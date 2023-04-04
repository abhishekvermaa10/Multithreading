package com.scaleupindia;

import com.scaleupindia.utility.MyThread;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo2 extends Thread {
	public static void main(String[] args) {
		Thread thread = new MyThread();
		thread.setDaemon(true);
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Executing " + Thread.currentThread().getName());
	}
}
