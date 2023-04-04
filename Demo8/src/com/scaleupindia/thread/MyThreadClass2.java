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
		synchronized (sharedResource.getResource1()) {
			while (true) {
				System.out.println("Lock acquired on reosurce1 by " + Thread.currentThread().getName());
			}
		}
	}
}