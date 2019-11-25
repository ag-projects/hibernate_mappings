package com.agharibi.hibernate.demo;

import com.agharibi.hibernate.Utils;
import com.agharibi.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Set;

public class SetDriver {

    public static void main(String[] args) {

        SessionFactory sessionFactory = Utils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Student student = new Student("Paul", "Wall", "paul@gmail.com");
            Set<String> images = student.getImages();
            images.add("pic1.jpg");
            images.add("pic2.jpg");
            images.add("pic3.jpg");
            images.add("pic4.jpg");
            student.setImages(images);

            session.persist(student);

            transaction.commit();
            System.err.println("All done!");

        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
