package com.scaleupindia.service.impl;

import com.scaleupindia.service.CounterService;

/**
 * @author abhishekvermaa10
 *
 */
public class CounterServiceImpl3 implements CounterService {
	private int count;

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void incrementCount() {
		synchronized (this) {
			++count;
		}
	}
}
