package com.scaleupindia;

import com.scaleupindia.thread.MyThreadClass1;
import com.scaleupindia.thread.MyThreadClass2;
import com.scaleupindia.utility.SharedResource;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo extends Thread {
	public static void main(String[] args) {
		SharedResource resources = new SharedResource("resource1", "resource2");
		Thread thread1 = new Thread(new MyThreadClass1(resources));
		Thread thread2 = new Thread(new MyThreadClass2(resources));
		thread1.start();
		thread2.start();
	}
}
