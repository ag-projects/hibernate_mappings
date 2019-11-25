package com.agharibi.hibernate.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Principle extends Person {

    @Column(name = "salary")
    private Double salary;

    public Principle() {
    }

    public Principle(String firstName, String lastName, String email, Double salary) {
        super(firstName, lastName, email);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Principle{" +
                "salary=" + salary +
                '}';
    }
}
