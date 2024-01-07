package com.mindex.challenge.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.exception.EmployeeNotFoundException;
import com.mindex.challenge.service.CompensationService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest {
	private String compUrl;
    private String compIdUrl;

    @Autowired
    private CompensationService compService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
    	compUrl = "http://localhost:" + port + "/compensation";
    	compIdUrl = "http://localhost:" + port + "/compensation/{id}";
    }

    @Test
    public void testCreateCompensation() {
    	String empId = "16a596ae-edd3-4847-99fe-c4518e82c86f";
 //   	Employee testemp1 = restTemplate.getForEntity(employeeIdUrl, Employee.class, empId).getBody();    	
    	
    	Compensation comp = new Compensation();
    	comp.setEmployeeId(empId);
    	comp.setSalary(new BigDecimal(100000));
    	comp.setEffectiveDate(new Date());
    	
    	Compensation postcomp = restTemplate.postForEntity(compUrl, comp, Compensation.class).getBody();
    	
    	assertNotNull(postcomp.getCompensationId());
    	assertEquals(empId, postcomp.getEmployeeId());
    	
    	Compensation readcomp = restTemplate.getForEntity(compIdUrl,Compensation.class, postcomp.getCompensationId()).getBody();
    	
    	assertEquals(readcomp.getCompensationId(),readcomp.getCompensationId());
    }
    
    @Test(expected=EmployeeNotFoundException.class)
    public void testCreateCompensationForNonExistentEmployee() {
    	String empId = "trolololol";
    	Compensation comp = new Compensation();
    	comp.setEmployeeId(empId);
    	comp.setSalary(new BigDecimal(100000));
    	comp.setEffectiveDate(new Date());
    	
    	Compensation postcomp = restTemplate.postForEntity(compUrl, comp, Compensation.class).getBody();
    	
    	assertNull(postcomp);
    }
}
