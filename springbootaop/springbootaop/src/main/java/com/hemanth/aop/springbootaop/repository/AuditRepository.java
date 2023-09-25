package com.hemanth.aop.springbootaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hemanth.aop.springbootaop.entity.AuditLog;

@Repository
public interface AuditRepository extends JpaRepository<AuditLog, Integer> {

}
