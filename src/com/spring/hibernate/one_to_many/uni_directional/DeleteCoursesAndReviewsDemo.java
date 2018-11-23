package com.spring.hibernate.one_to_many.uni_directional;

import com.spring.hibernate.one_to_many.uni_directional.entity.Course;
import com.spring.hibernate.one_to_many.uni_directional.entity.Instructor;
import com.spring.hibernate.one_to_many.uni_directional.entity.InstructorDetail;
import com.spring.hibernate.one_to_many.uni_directional.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesAndReviewsDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("com/spring/hibernate/one_to_many/hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Review.class)
            .buildSessionFactory()
        ) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Fetch a course.
            int courseId = 10;
            Course course = session.get(Course.class, courseId);

            // Print course
            System.out.println(course);

            // Print reviews.
            System.out.println(course.getReviews());

            //Delete course
            session.delete(course);

            session.getTransaction().commit();
        }
    }
}
