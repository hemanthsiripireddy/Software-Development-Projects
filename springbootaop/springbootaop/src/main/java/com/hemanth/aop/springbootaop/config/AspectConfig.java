package com.hemanth.aop.springbootaop.config;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.hemanth.aop.springbootaop.entity.AuditLog;
import com.hemanth.aop.springbootaop.entity.Employee;
import com.hemanth.aop.springbootaop.repository.AuditRepository;
import com.hemanth.aop.springbootaop.service.EmployeeService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Aspect
@Slf4j
public class AspectConfig {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	AuditRepository auditRepository;
	@Autowired
	EmployeeService employeeService;
//	@Before("execution(public * com.hemanth.aop.springbootaop.serviceImpl.*.*(..) )")
//	public void logBeforeAllMethods(JoinPoint joinPoint) {
//	log.info(joinPoint.getSignature().getName()+" Started");
//		
//	}
//	
//	@After("execution(public * com.hemanth.aop.springbootaop.serviceImpl.*.*(..) )")
//	public void logAfterAllMethods(JoinPoint joinPoint) {
//	log.info(joinPoint.getSignature().getName()+" Ended");
//		
//	}

	@Around("execution(public * com.hemanth.aop.springbootaop.serviceImpl.*.*(..) )")
	public void logBeforeAndAfterAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		log.info(proceedingJoinPoint.getSignature().getName() + " started");
		proceedingJoinPoint.proceed();
		log.info(proceedingJoinPoint.getSignature().getName() + " ended");
	}

	@AfterReturning("execution(public * com.hemanth.aop.springbootaop.serviceImpl.EmployeeServiceImpl.addEmployee(..) )")
	public void logBeforeAddEmployee(JoinPoint joinPoint) {
		long count = auditRepository.count();
		AuditLog auditLog = AuditLog.builder().createDate(new Date())
				.descriptiont("Details of employee added" + joinPoint.getArgs()[0]);
		auditRepository.saveAndFlush(auditLog);
	}
	
	@AfterThrowing("execution(public * com.hemanth.aop.springbootaop.serviceImpl.EmployeeServiceImpl.updateEmployee(..) )")
	public void logErrorWhileUpdatingEmployee(JoinPoint joinPoint) {
		Employee employee=(Employee)joinPoint.getArgs()[0];
		AuditLog auditLog = AuditLog.builder().createDate(new Date())
				.descriptiont("Error while updating  employee since there is no employee with id " + employee.getId());
		auditRepository.save(auditLog);
	}

}
