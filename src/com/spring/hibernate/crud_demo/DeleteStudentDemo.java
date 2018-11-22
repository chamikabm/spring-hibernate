package com.spring.hibernate.crud_demo;

import com.spring.hibernate.crud_demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration().configure("com/spring/hibernate/one_to_one/hibernate.cfg.xml")
        .addAnnotatedClass(Student.class)
        .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            int studentId = 2;
            Student student = session.get(Student.class, studentId);
            session.delete(student);

            session.createQuery("delete from Student where id=4").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
