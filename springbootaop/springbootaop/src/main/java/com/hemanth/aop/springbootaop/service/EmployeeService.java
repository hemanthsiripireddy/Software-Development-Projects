package com.hemanth.aop.springbootaop.service;

import java.util.Optional;

import com.hemanth.aop.springbootaop.entity.Employee;

public interface EmployeeService {
	
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	Optional<Employee>getEmployeeById(Integer id);
	void deleteEmployeeById(int id);

}
