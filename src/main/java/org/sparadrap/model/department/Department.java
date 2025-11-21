package org.sparadrap.model.department;

import java.util.ArrayList;

// french land department
public class Department {
    private int id;
    private String name;
    private String number;

// constructor
    public Department(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

// getters and setters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
