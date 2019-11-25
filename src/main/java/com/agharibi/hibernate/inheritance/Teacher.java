package com.agharibi.hibernate.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Teacher extends Person {

    @Column(name = "course")
    private String course;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String email, String course) {
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
        return "Teacher{" +
                "course='" + course + '\'' +
                '}';
    }
}
