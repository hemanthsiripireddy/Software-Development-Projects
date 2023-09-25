package com.hemanth.aop.springbootaop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class AuditLog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition = "date default sysdate")
	private Date createDate;
	
	private String description;
	
	
	public static AuditLog builder() {
		
		return new AuditLog();
			
		
	}
	
	@Override
	public String toString() {
		return "AuditLog [id=" + id + ", createDate=" + createDate + ", description=" + description + "]";
	}

	public AuditLog() {
		super();
	}

	public AuditLog(Integer id, Date createDate, String description) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	

	public AuditLog createDate(Date date) {
		this.createDate=date;
		return this;
	}
	public AuditLog descriptiont(String str) {
		this.description=str;
		return this;
	}
	
	
	
	
	
	
	

}
