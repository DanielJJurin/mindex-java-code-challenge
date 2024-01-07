package com.mindex.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

@Component
public class DataBootstrap {
    private static final String DATASTORE_LOCATION = "/static/employee_database.json";

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private CompensationRepository compensationRepository;

    @PostConstruct
    public void init() {
        InputStream inputStream = this.getClass().getResourceAsStream(DATASTORE_LOCATION);

        Employee[] employees = null;

        try {
            employees = objectMapper.readValue(inputStream, Employee[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Employee employee : employees) {
            employeeRepository.insert(employee);

            // Additional Data for testing
            
            if (employee.getEmployeeId().equals("16a596ae-edd3-4847-99fe-c4518e82c86f")) {
            	Compensation comp = new Compensation();
            	comp.setEmployeeId(employee.getEmployeeId());
            	comp.setSalary(new BigDecimal(100000));
            	comp.setEffectiveDate(new Date());
            	Compensation newcomp = compensationRepository.insert(comp);	
            	System.out.println(newcomp.getCompensationId());
            }
        }
        
        
    	
    	
    }
}
