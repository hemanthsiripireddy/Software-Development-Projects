package com.hemanth.aop.springbootaop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemanth.aop.springbootaop.entity.AuditLog;
import com.hemanth.aop.springbootaop.repository.AuditRepository;

@RestController
@RequestMapping("/audit")
public class AuditController {
	
	@Autowired
	AuditRepository auditRepository;
	
	
	@GetMapping("/logs")
	public List<AuditLog> getRecords() {
		return auditRepository.findAll();
	}
	
	
	

}
