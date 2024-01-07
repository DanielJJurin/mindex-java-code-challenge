package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.exception.EmployeeNotFoundException;
import com.mindex.challenge.service.ReportingStructureService;

@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureService.class);

    @Autowired
    private ReportingStructureService reportService;
	
	@GetMapping("/reportstructure/{id}")
    public ReportingStructure read(@PathVariable String id) throws EmployeeNotFoundException {
        LOG.debug("Received employee create request for id [{}]", id);

        return reportService.read(id);
    }
	
	@ExceptionHandler({ EmployeeNotFoundException.class})
    public void handleException() {
        return;
    }
}
