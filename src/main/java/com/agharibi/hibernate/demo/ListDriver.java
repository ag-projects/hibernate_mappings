package com.agharibi.hibernate.demo;

import com.agharibi.hibernate.Utils;
import com.agharibi.hibernate.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ListDriver {

    public static void main(String[] args) {

        SessionFactory sessionFactory = Utils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Employee employee = new Employee("Paul", "Wall", "paul@gmail.com");

            List<String> images = employee.getImages();
            images.add("pic1.jpg");
            images.add("pic2.jpg");
            images.add("pic3.jpg");
            images.add("pic4.jpg");

            session.persist(employee);

            transaction.commit();
            System.err.println("All done!");

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
