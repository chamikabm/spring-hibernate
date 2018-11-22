package com.spring.hibernate.one_to_one;

import com.spring.hibernate.one_to_one.entity.Instructor;
import com.spring.hibernate.one_to_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalGetDemo {
    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("com/spring/hibernate/one_to_one/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();
        ) {

            session.beginTransaction();

            int instructorDetailId = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);

            System.out.println(instructorDetail);
            System.out.println();
            System.out.println(instructorDetail.getInstructor());

            session.getTransaction().commit();
        }
    }
}
