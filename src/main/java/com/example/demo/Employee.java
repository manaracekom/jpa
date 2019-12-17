package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Employee")
@Table(name = "employee")
public class Employee {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String gender;
    private int salary;

    public Employee() {}

    public Employee(String id, String firstName, String lastName, String gender, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=%s, firstName='%s', lastName='%s', gender='%s', salary=%s]",
                id, firstName, lastName, gender, salary);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
