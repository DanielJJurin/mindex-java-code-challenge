package com.mindex.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.exception.EmployeeNotFoundException;
import com.mindex.challenge.service.ReportingStructureService;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    
	@Override
	public ReportingStructure read(String id) throws EmployeeNotFoundException {
		LOG.debug("Selecting reporting structure of employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Invalid employeeId: " + id);
        }
        ReportingStructure reps = new ReportingStructure(employee);

        return reps;
	}

}
