package com.scaleupindia.service.impl;

import com.scaleupindia.service.CounterService;

/**
 * @author abhishekvermaa10
 *
 */
public class CounterServiceImpl implements CounterService {
	private int count;

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void incrementCount() {
		++count;
		System.out.println(Thread.currentThread().getName() + " made count as " + count);
	}
}
