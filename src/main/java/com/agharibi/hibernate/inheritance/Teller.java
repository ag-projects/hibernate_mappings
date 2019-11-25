package com.agharibi.hibernate.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Teller extends Banker {

    @Column(name = "course")
    private String course;

    public Teller() {
    }

    public Teller(String firstName, String lastName, String email, String course) {
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
        return "Teller{" +
                "course='" + course + '\'' +
                '}';
    }
}
