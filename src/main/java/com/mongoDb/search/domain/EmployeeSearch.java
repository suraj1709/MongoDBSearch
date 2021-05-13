package com.mongoDb.search.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EmployeeSearch {

    @Id
    private int key;

    private Employee value;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Employee getValue() {
        return value;
    }

    public void setValue(Employee value) {
        this.value = value;
    }
}
