package com.agharibi.hibernate.demo;

import com.agharibi.hibernate.Utils;
import com.agharibi.hibernate.inheritance.Dev;
import com.agharibi.hibernate.inheritance.DevOps;
import com.agharibi.hibernate.inheritance.Financier;
import com.agharibi.hibernate.inheritance.Teller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class JoinedTableInheritance {

    public static void main(String[] args) {
        SessionFactory sessionFactory = Utils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();

            Teller teller = new Teller("Paul", "Wall", "paul@gmail.com", "Hibernate");
            Financier financier = new Financier("John", "Doe", "john@gmail.com", 2000.00);

            session.save(teller);
            session.save(financier);

            transaction.commit();
            System.err.println("All done!");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
