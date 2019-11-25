package com.agharibi.hibernate.inheritance;

import javax.persistence.Entity;

@Entity
public class DevOps extends Engineer {

    private Double salary;

    public DevOps() {
    }

    public DevOps(String firstName, String lastName, String email, Double salary) {
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
        return "DevOps{" +
                "salary=" + salary +
                '}';
    }
}
