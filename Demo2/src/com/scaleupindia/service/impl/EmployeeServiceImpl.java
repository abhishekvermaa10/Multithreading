package com.scaleupindia.service.impl;

import com.scaleupindia.repository.EmployeeRepository;

/**
 * @author abhishekvermaa10
 *
 */
public class EmployeeServiceImpl implements Runnable {
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " started fetching from : " + employeeRepository);
		employeeRepository.displayEmployees();
		System.out.println(Thread.currentThread().getName() + " finished fetching from : " + employeeRepository);
	}
}
