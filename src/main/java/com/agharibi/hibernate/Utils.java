package com.agharibi.hibernate;

import com.agharibi.hibernate.inheritance.*;
import com.agharibi.hibernate.model.Employee;
import com.agharibi.hibernate.model.Employer;
import com.agharibi.hibernate.model.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utils {

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Employer.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Engineer.class)
                .addAnnotatedClass(Dev.class)
                .addAnnotatedClass(DevOps.class)
                .addAnnotatedClass(Banker.class)
                .addAnnotatedClass(Teller.class)
                .addAnnotatedClass(Financier.class)
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Principle.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        return sessionFactory;
    }
}
