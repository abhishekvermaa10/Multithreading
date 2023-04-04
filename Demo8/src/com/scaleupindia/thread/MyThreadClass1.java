package com.scaleupindia.thread;

import com.scaleupindia.utility.SharedResource;

public class MyThreadClass1 implements Runnable {
	private SharedResource sharedResource;

	public MyThreadClass1(SharedResource sharedResource) {
		super();
		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		synchronized (sharedResource.getResource1()) {
			while (true) {
				System.out.println("Lock acquired on reosurce1 by " + Thread.currentThread().getName());
			}
		}
	}
}