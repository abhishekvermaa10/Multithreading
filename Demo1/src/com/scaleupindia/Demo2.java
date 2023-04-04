package com.scaleupindia;

import com.scaleupindia.repository.EmployeeRepository;
import com.scaleupindia.repository.impl.EmployeeRepositoryImpl1;
import com.scaleupindia.repository.impl.EmployeeRepositoryImpl2;
import com.scaleupindia.repository.impl.EmployeeRepositoryImpl3;
import com.scaleupindia.service.impl.EmployeeServiceImpl;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " started fetching");
		EmployeeServiceImpl employeeServiceImpl = null;
		EmployeeRepository[] employeeRepositories = { new EmployeeRepositoryImpl1(), new EmployeeRepositoryImpl2(),
				new EmployeeRepositoryImpl3() };
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < employeeRepositories.length; i++) {
			employeeServiceImpl = new EmployeeServiceImpl(employeeRepositories[i]);
			employeeServiceImpl.start();
		}
		
		System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " milliseconds");
		System.out.println(Thread.currentThread().getName() + " finished fetching");
	}
}
