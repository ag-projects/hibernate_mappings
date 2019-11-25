package com.agharibi.hibernate.demo;

import com.agharibi.hibernate.Utils;
import com.agharibi.hibernate.inheritance.Dev;
import com.agharibi.hibernate.inheritance.DevOps;
import com.agharibi.hibernate.inheritance.Instructor;
import com.agharibi.hibernate.inheritance.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TablePerClassInheritance {

    public static void main(String[] args) {
        SessionFactory sessionFactory = Utils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Dev dev = new Dev("Paul", "Wall", "paul@gmail.com", "Hibernate");
            DevOps devOps = new DevOps("John", "Doe", "john@gmail.com", 2000.00);

            session.save(dev);
            session.save(devOps);

            transaction.commit();
            System.err.println("All done!");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
