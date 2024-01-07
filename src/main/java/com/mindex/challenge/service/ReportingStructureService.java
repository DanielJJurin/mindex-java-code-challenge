package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.exception.EmployeeNotFoundException;

public interface ReportingStructureService {
    ReportingStructure read(String id) throws EmployeeNotFoundException;
}
