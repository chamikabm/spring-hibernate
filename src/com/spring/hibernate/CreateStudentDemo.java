package com.spring.hibernate;

import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        Student student = new Student("chamika", "kasun", "chamika@gmail.com");

        // Create a new session factory.
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

       try {
           // Create a new session.
           Session session = sessionFactory.getCurrentSession();

           // Start a transaction.
           session.beginTransaction();

           // Save student object.
           session.save(student);

           // Commit the transaction.
           session.getTransaction().commit();
       } finally {
           sessionFactory.close();
       }
    }
}
