package com.mongoDb.search.repositories;

import com.mongoDb.search.domain.Employee;
import com.mongoDb.search.domain.EmployeeSearch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeSearch, Integer> {

    List<EmployeeSearch> findByValue(Employee employee);

}
