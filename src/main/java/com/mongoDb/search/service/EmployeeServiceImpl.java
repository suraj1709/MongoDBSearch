package com.mongoDb.search.service;

import com.mongoDb.search.domain.Employee;
import com.mongoDb.search.domain.EmployeeSearch;
import com.mongoDb.search.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MongoTemplate mongoTemplate;



    @Override
    public void save(EmployeeSearch employeeSearch) {
        employeeRepository.save(employeeSearch);
    }

    @Override
    public List<Employee> search(Employee employee) {
        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
        if (employee.getName()!=null && !employee.getName().isEmpty())
            criteria.add(Criteria.where("value.name").is(employee.getName()));
        if (employee.getTeamName()!=null && !employee.getTeamName().isEmpty())
            criteria.add(Criteria.where("value.teamName").is(employee.getTeamName()));
        if (!criteria.isEmpty())
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        List<EmployeeSearch> search= mongoTemplate.find(query, EmployeeSearch.class);
        return search.stream().map(e->e.getValue()).collect(Collectors.toList());
    }
}
