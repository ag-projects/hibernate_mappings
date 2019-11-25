package com.agharibi.hibernate.demo;

import com.agharibi.hibernate.Utils;
import com.agharibi.hibernate.inheritance.Instructor;
import com.agharibi.hibernate.inheritance.Principle;
import com.agharibi.hibernate.inheritance.Student;
import com.agharibi.hibernate.inheritance.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MappedSuperClassInheritance {

    public static void main(String[] args) {
        SessionFactory sessionFactory = Utils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Teacher teacher = new Teacher("Paul", "Wall", "paul@gmail.com", "Hibernate");
            Principle principle = new Principle("John", "Doe", "john@gmail.com", 2000.00);

            session.save(teacher);
            session.save(principle);

            transaction.commit();
            System.err.println("All done!");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
