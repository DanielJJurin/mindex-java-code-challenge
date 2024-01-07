package com.mindex.challenge.data;

//import org.springframework.data.mongodb.core.mapping.DBRef;

/* I wondered if I could have gotten the reporting just by modifying the endpoint of the EmployeeController and deriving 
 * the relevant information from the Employee class, and skipped making the ReportingStructure class.  
 * The specification hinted I should go with this methodology though, so I did it this way.
*/
public class ReportingStructure {

//	@DBRef
//	private Employee employee;
//	
	private String employeeId;
    private int numberOfReports;
    public ReportingStructure() {
    	
    }
    /** 
     * The ReportingStructure class is meant to be a transitory class that derives a report from Employee objects. It should be able to get all information from a provided
     * Employee object.
     * @param emp Employee to derive information from
     */
    public ReportingStructure(Employee emp) {
    	this.employeeId = emp.getEmployeeId();
    	if (emp.getDirectReports() == null) {
    		this.numberOfReports = 0;
    	} else {
    		this.numberOfReports = emp.getDirectReports().size();
    	}
    }
    
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getNumberOfReports() {
		return numberOfReports;
	}
	public void setNumberOfReports(int numberOfReports) {
		this.numberOfReports = numberOfReports;
	}

//    public ReportingStructure(Employee emp) {
//    	this.employee = emp;
//    	if (emp.getDirectReports() == null) {
//    		this.numberOfReports = 0;
//    	} else {
//    		this.numberOfReports = emp.getDirectReports().size();
//    	}
//    }
//    
//	public Employee getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Employee emp) {
//		this.employee = emp;
//	}
//	public int getNumberOfReports() {
//		return numberOfReports;
//	}
//	public void setNumberOfReports(int numberOfReports) {
//		this.numberOfReports = numberOfReports;
//	}
//
    
}
