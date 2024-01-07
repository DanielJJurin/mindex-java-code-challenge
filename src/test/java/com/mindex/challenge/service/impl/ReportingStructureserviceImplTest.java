package com.mindex.challenge.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.exception.EmployeeNotFoundException;
import com.mindex.challenge.service.ReportingStructureService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureserviceImplTest {
    private String employeeIdUrl;

    @Autowired
    private ReportingStructureService repService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        employeeIdUrl = "http://localhost:" + port + "/reportstructure/{id}";
    }

    // http://localhost:8080/reportstructure/16a596ae-edd3-4847-99fe-c4518e82c86f
    @Test
    public void testEmployeeWithReports() {
    	String testId = "16a596ae-edd3-4847-99fe-c4518e82c86f";
    	int numreports = 2;
    	ReportingStructure rs = restTemplate.getForEntity(employeeIdUrl, ReportingStructure.class, testId).getBody();
    	assertNotNull(rs);
    	assertEquals(rs.getNumberOfReports(), numreports);
    }
    // http://localhost:8080/reportstructure/c0c2293d-16bd-4603-8e08-638a9d18b22c
    @Test
    public void testEmployeeWithNoReports() {
    	String testId = "c0c2293d-16bd-4603-8e08-638a9d18b22c";
    	int numreports = 0;
    	ReportingStructure rs = restTemplate.getForEntity(employeeIdUrl, ReportingStructure.class, testId).getBody();
    	assertNotNull(rs);
    	assertEquals(rs.getNumberOfReports(), numreports);
    }
    @Test(expected=EmployeeNotFoundException.class)
    public void testEmployeeNotExist() {
    	String testId = "lololololololol";
    	ReportingStructure rs = restTemplate.getForEntity(employeeIdUrl, ReportingStructure.class, testId).getBody();
    	assertNull(rs);
    }
}
