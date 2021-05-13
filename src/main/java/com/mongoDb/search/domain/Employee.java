package com.mongoDb.search.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Employee {

    private String name;
    private String teamName;



    public Employee( String name, String teamName) {

        this.name = name;
        this.teamName = teamName;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


}
