package com.mindex.challenge.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.exception.CompensationNotFoundException;
import com.mindex.challenge.exception.EmployeeNotFoundException;
import com.mindex.challenge.service.CompensationService;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);
    
	@Autowired
	private CompensationRepository compRepository;
	@Autowired
	private EmployeeRepository empRepository;
	
	@Override
	public Compensation create(Compensation comp) throws EmployeeNotFoundException {
		LOG.debug("Creating compensation with id [{}]", comp.getCompensationId());

		String id = comp.getEmployeeId();
		
		// Make sure the referenced employee ID exists
		Employee employee = empRepository.findByEmployeeId(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Invalid employeeId: " + id);
        }

        comp.setCompensationId(UUID.randomUUID().toString());
        compRepository.insert(comp);

		return comp;
	}

	@Override
	public Compensation read(String id) throws CompensationNotFoundException {
		// TODO Auto-generated method stub
		LOG.debug("Retrieving compensation id [{}]", id);
		
		Compensation comp = compRepository.findByCompensationId(id);
		if (comp == null) {
            throw new CompensationNotFoundException("Invalid compensationId: " + id);
		}
		return comp;
	}

}
