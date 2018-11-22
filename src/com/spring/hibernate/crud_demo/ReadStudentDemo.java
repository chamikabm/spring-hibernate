package com.spring.hibernate.crud_demo;

import com.spring.hibernate.crud_demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("com/spring/hibernate/mappings_demo/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            Student student = new Student("cham", "bam", "abc@gmail.com");

            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();


            // Here you can't use the same session which is used to a commit a transaction as that
            // session already closed. Hence we need to get a new session from the session factory.
            session = sessionFactory.getCurrentSession();
            Student student2 = new Student("ddd", "bam", "abc@gmail.com");
            session.beginTransaction();
            session.save(student2);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Student helloStudent = session.get(Student.class, student2.getId());
            session.getTransaction().commit();
            System.out.println("Hello!! Student " + helloStudent.getFirstName());
        }
    }
}
