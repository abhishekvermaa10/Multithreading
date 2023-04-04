package com.scaleupindia.thread;

import com.scaleupindia.utility.SharedResource;

public class MyThreadClass2 implements Runnable {
	private SharedResource sharedResource;

	public MyThreadClass2(SharedResource sharedResource) {
		super();
		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		synchronized (sharedResource.getResource2()) {
			System.out.println("Lock acquired on reosurce2 by " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Waiting to acquire lock on reosurce1 by " + Thread.currentThread().getName());
			synchronized (sharedResource.getResource1()) {
				System.out.println("Lock acquired on reosurce1 by " + Thread.currentThread().getName());
			}
		}
	}
}