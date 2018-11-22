package com.spring.hibernate.crud_demo;

import com.spring.hibernate.crud_demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class PrimaryKeyDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("com/spring/hibernate/mappings_demo/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory(); Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            Student student1 = new Student("chamika1", "kasun1", "chamika1@gmail.com");
            Student student2 = new Student("chamika2", "kasun2", "chamika2@gmail.com");
            Student student3 = new Student("chamika3", "kasun3", "chamika3@gmail.com");

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();

        }

    }
}
