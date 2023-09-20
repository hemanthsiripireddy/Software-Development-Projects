package com.hemanth.aop.springbootaop.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemanth.aop.springbootaop.entity.Employee;
import com.hemanth.aop.springbootaop.repository.EmpolyeeRepository;
import com.hemanth.aop.springbootaop.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmpolyeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.saveAndFlush(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.saveAndFlush(employee);
		
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}

}
