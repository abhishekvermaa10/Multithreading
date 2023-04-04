package com.scaleupindia.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.scaleupindia.entity.Employee;
import com.scaleupindia.repository.EmployeeRepository;

/**
 * @author abhishekvermaa10
 *
 */
public class EmployeeRepositoryImpl1 implements EmployeeRepository {
	private static List<Employee> employeeList = new ArrayList<>();

	static {
		employeeList.add(new Employee(101, "Abhishek"));
		employeeList.add(new Employee(102, "Sneh"));
		employeeList.add(new Employee(103, "Lakshay"));
		employeeList.add(new Employee(104, "Aditi"));
		employeeList.add(new Employee(105, "Raman"));
	}

	@Override
	public void displayEmployees() {
		for (Employee employee : employeeList) {
			System.out.println(employee);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "EmployeeRepositoryImpl1";
	}
}