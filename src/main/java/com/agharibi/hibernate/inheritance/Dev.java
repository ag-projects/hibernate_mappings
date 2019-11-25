package com.agharibi.hibernate.inheritance;

import javax.persistence.Entity;

@Entity
public class Dev extends Engineer {

    private String course;

    public Dev() {
    }

    public Dev(String firstName, String lastName, String email, String course) {
        super(firstName, lastName, email);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Dev{" +
                "course='" + course + '\'' +
                '}';
    }
}
