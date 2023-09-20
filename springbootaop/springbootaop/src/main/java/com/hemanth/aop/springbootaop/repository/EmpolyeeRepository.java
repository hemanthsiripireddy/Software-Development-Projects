package com.hemanth.aop.springbootaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemanth.aop.springbootaop.entity.Employee;

public interface EmpolyeeRepository extends JpaRepository<Employee,Integer> {

}
