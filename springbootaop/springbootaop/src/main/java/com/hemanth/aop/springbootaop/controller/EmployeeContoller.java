package com.hemanth.aop.springbootaop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hemanth.aop.springbootaop.entity.Employee;
import com.hemanth.aop.springbootaop.service.EmployeeService;

@RestController
public class EmployeeContoller {
	@Autowired
	EmployeeService employeeService;
	@PostMapping(path="/addEmployee",consumes="application/json")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return "Employee Added";
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee( @RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return "Employee Updated";
	}
	
	@GetMapping("/getEmployeeById")
	public  Optional<Employee> getEmployeeById( int id){
		return employeeService.getEmployeeById(id);
	}
	

	@DeleteMapping("/deleteEmployeeById")
	public @ResponseBody String deleteEmployeeById(int id){
		 employeeService.deleteEmployeeById(id);
		 return "Employee Deleted";
	}

}
