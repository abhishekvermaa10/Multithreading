package com.scaleupindia;

import com.scaleupindia.utility.Criminal;
import com.scaleupindia.utility.Police;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo extends Thread {
	private static final Police POLICE = new Police();
	private static final Criminal CRIMINAL = new Criminal();

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				POLICE.giveRansom(CRIMINAL);
			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				CRIMINAL.releaseHostage(POLICE);
			}
		});
		t2.start();
	}
}
