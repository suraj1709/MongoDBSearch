package com.mongoDb.search.controller;


import com.mongoDb.search.domain.Employee;
import com.mongoDb.search.domain.EmployeeSearch;
import com.mongoDb.search.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee")
@Tag(name="Search Api",description = "Search  API")
public class EmployeeSearchController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(description = "Save Employee")
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody EmployeeSearch employeeSearch)
    {
        employeeService.save(employeeSearch);
    return ResponseEntity.ok("saved");
    }

    @Operation(description = "Fetch similar ")
    @PostMapping("/search")
    public ResponseEntity<List<Employee>> search(@RequestBody Employee employee)
    {
        List<Employee> response=employeeService.search(employee);
        System.out.println(response);
        return ResponseEntity.ok(response);
    }
}
