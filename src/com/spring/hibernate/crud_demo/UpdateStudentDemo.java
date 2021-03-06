package com.spring.hibernate.crud_demo;

import com.spring.hibernate.crud_demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration().configure("com/spring/hibernate/one_to_one/hibernate.cfg.xml")
        .addAnnotatedClass(Student.class)
        .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            int studentId = 1;
            Student student = session.get(Student.class, studentId);
            // You don't need to explicitly save after updating values as this retrieved from db and actual
            // commit happens after updating the value in the memory. (i.e  session.getTransaction().commit())
            student.setFirstName("Hello");
            session.getTransaction().commit();

            session =  sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student as s set s.email='chamika@gmail.com'").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
