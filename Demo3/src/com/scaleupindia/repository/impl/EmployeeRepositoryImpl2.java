package com.scaleupindia.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.scaleupindia.entity.Employee;
import com.scaleupindia.repository.EmployeeRepository;

/**
 * @author abhishekvermaa10
 *
 */
public class EmployeeRepositoryImpl2 implements EmployeeRepository {
	private static List<Employee> employeeList = new ArrayList<>();

	static {
		employeeList.add(new Employee(201, "Amar"));
		employeeList.add(new Employee(202, "Mohan"));
		employeeList.add(new Employee(203, "Nancy"));
		employeeList.add(new Employee(204, "Astha"));
		employeeList.add(new Employee(205, "Rohit"));
	}

	@Override
	public void displayEmployees() {
		for (Employee employee : employeeList) {
			//System.out.println(employee);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "EmployeeRepositoryImpl2";
	}
}