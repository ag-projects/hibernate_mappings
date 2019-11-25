package com.agharibi.hibernate.demo;

import com.agharibi.hibernate.inheritance.Instructor;
import com.agharibi.hibernate.Utils;
import com.agharibi.hibernate.inheritance.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SingleTableInheritance {

    public static void main(String[] args) {
        SessionFactory sessionFactory = Utils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Student student = new Student("Paul", "Wall", "paul@gmail.com", "Hibernate");
            Instructor instructor = new Instructor("John", "Doe", "john@gmail.com", 2000.00);

            session.save(student);
            session.save(instructor);

            transaction.commit();
            System.err.println("All done!");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
