package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.exception.CompensationNotFoundException;
import com.mindex.challenge.exception.EmployeeNotFoundException;

public interface CompensationService {
    Compensation create(Compensation employee) throws EmployeeNotFoundException;
    Compensation read(String id) throws CompensationNotFoundException;
}
