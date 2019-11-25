package com.agharibi.hibernate;

import com.agharibi.hibernate.model.Address;
import com.agharibi.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        System.out.println("Hibernate Configuration loaded");


        /**
         * Added entities to the hibernate configuration here..
         */
        config.addAnnotatedClass(Student.class).addAnnotatedClass(Address.class);


        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction transaction = session.getTransaction();


        Address address = new Address();
        address.setStreet("123 Main Street");
        address.setCity("Pasadena");
        address.setState("CA");

        transaction.begin();

        Student armen = new Student();
//        armen.setGrade(98);
//        armen.setName("Armen Gharibi");
//        armen.setAddress(address);
        session.save(armen);

        transaction.commit();

    }

}
