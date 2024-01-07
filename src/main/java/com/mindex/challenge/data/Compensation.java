package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.DBRef;
//import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class Compensation {
	@Id
	private String compensationId;
	//@DocumentReference
	//@DBRef
	//private Employee employee;
	private String employeeId;
	private BigDecimal salary;
	private Date effectiveDate;
	
	public Compensation() {
		
	}

//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getCompensationId() {
		return compensationId;
	}

	public void setCompensationId(String compensationId) {
		this.compensationId = compensationId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
