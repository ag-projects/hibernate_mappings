package com.agharibi.hibernate.demo;

import com.agharibi.hibernate.Utils;
import com.agharibi.hibernate.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Map;

public class HashMapDriver {

    public static void main(String[] args) {
        SessionFactory sessionFactory = Utils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Movie movie = new Movie("Lion King", "Oliver Stone", "Comedy");
            Map<String, String> images = movie.getImages();
            images.put("pic01.jpg", "pic01");
            images.put("pic02.jpg", "pic02");
            images.put("pic03.jpg", "pic03");
            images.put("pic04.jpg", "pic04");

            session.persist(movie);

            transaction.commit();
            System.err.println("All done!");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
