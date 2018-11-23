package com.spring.hibernate.many_to_many;

import com.spring.hibernate.many_to_many.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("com/spring/hibernate/many_to_many/hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Review.class)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Student.class)
            .buildSessionFactory()
        ) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            int courseId = 10;

            Course course = session.get(Course.class, courseId);

            System.out.println(course);
            System.out.println(course.getStudents());
            System.out.println(course.getStudents().get(0).getCourses());

            session.getTransaction().commit();
        }
    }
}
