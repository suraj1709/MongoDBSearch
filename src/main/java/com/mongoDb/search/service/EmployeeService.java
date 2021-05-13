package com.mongoDb.search.service;

import com.mongoDb.search.domain.Employee;
import com.mongoDb.search.domain.EmployeeSearch;

import java.util.List;

public interface EmployeeService {

    void save(EmployeeSearch employeeSearch);

    List<Employee> search(Employee employee);
}
