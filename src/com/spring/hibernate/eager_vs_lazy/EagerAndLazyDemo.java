package com.spring.hibernate.eager_vs_lazy;

import com.spring.hibernate.eager_vs_lazy.entity.Course;
import com.spring.hibernate.eager_vs_lazy.entity.Instructor;
import com.spring.hibernate.eager_vs_lazy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerAndLazyDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("com/spring/hibernate/eager_vs_lazy/hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .buildSessionFactory()
        ) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Get the instruction from the database.
            int instructorId = 1;
            Instructor instructor = session.get(Instructor.class, instructorId);

            session.close(); // Comment this to work the code.

            System.out.println(instructor.getCourses());

            session.getTransaction().commit();
        }
    }
}
