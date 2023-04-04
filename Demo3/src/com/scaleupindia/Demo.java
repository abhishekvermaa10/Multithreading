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
public class Demo {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " started fetching");
		EmployeeServiceImpl employeeServiceImpl = null;
		EmployeeRepository[] employeeRepositories = { new EmployeeRepositoryImpl1(), new EmployeeRepositoryImpl2(),
				new EmployeeRepositoryImpl3() };
		Thread[] employeeServices = new Thread[employeeRepositories.length];
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < employeeRepositories.length; i++) {
			employeeServiceImpl = new EmployeeServiceImpl(employeeRepositories[i]);
			employeeServices[i] = new Thread(employeeServiceImpl);
			System.out.println("Just after using new keyword -> Name: " + employeeServices[i].getName() + ", isAlive: " + employeeServices[i].isAlive() + ", state: " + employeeServices[i].getState());
			employeeServices[i].start();
			System.out.println("Just after using start method -> Name: " + employeeServices[i].getName() + ", isAlive: " + employeeServices[i].isAlive() + ", state: " + employeeServices[i].getState());
		}
		
		for (int i = 0; i < employeeServices.length; i++) {
			try {
				employeeServices[i].join();
				System.out.println("Just after using join method -> Name: " + employeeServices[i].getName() + ", isAlive: " + employeeServices[i].isAlive() + ", state: " + employeeServices[i].getState());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " milliseconds");
		System.out.println(Thread.currentThread().getName() + " finished fetching");
	}
}
