package com.agharibi.hibernate.demo;

import com.agharibi.hibernate.Utils;
import com.agharibi.hibernate.model.Employer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Set;

public class LinkedHashSetDriver {

    public static void main(String[] args) {
        SessionFactory sessionFactory = Utils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Employer employer = new Employer("Paul", "Wall", "paul@gmail.com");
            Set<String> images = employer.getImages();
            images.add("pic1.jpg");
            images.add("pic2.jpg");
            System.out.println();
            images.add("pic3.jpg");

            employer.setImages(images);

            session.persist(employer);

            transaction.commit();
            System.err.println("All done!");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
