package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.exception.CompensationNotFoundException;
import com.mindex.challenge.exception.EmployeeNotFoundException;
import com.mindex.challenge.service.CompensationService;

@RestController
public class CompensationController {
	private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);
	
	@Autowired
	private CompensationService compService;
	
	@PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation comp) throws EmployeeNotFoundException {
        LOG.debug("Received compensation create request for [{}]", comp);

        return compService.create(comp);
    }

    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) throws CompensationNotFoundException {
        LOG.debug("Received compensation select request for id [{}]", id);

        return compService.read(id);
    }
    
    @ExceptionHandler({ EmployeeNotFoundException.class, CompensationNotFoundException.class })
    public void handleException() {
        return;
    }
}
