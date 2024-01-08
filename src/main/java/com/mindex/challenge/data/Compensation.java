package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Compensation {
	@Id
	private String compensationId;
	// I tried to get an Employee Object with @DBRef set up so it could have the object Java side and the reference database side. I couldn't get that to work. 
	// @DBRef I found only works with collections. In the end I opted for just having an employeeId, makes the MongoDB database data simpler. Gives a few hurdles for the java
	// side but accomodations can be made.
	private String employeeId;
	private BigDecimal salary;
	private Date effectiveDate;
	
	public Compensation() {
		
	}

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
