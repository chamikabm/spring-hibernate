package com.spring.hibernate.one_to_many.bi_directional;

import com.spring.hibernate.one_to_many.bi_directional.entity.Course;
import com.spring.hibernate.one_to_many.bi_directional.entity.Instructor;
import com.spring.hibernate.one_to_many.bi_directional.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("com/spring/hibernate/one_to_many/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()
        ) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            int courseId = 10;
            Course course = session.get(Course.class, courseId);
            session.delete(course);

            session.getTransaction().commit();
        }
    }
}
