package com.spring.hibernate;

import com.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            @SuppressWarnings("JpaQlInspection")
            List<Student> students = session.createQuery("from Student").getResultList();

            for(Student student: students) {
                System.out.println(student);
            }

            students = session.createQuery("from Student as s where " +
                    "s.email LIKE 'ab%'").getResultList();

            for(Student student: students) {
                System.out.println(student);
            }

            session.getTransaction().commit();
        }
    }
}
