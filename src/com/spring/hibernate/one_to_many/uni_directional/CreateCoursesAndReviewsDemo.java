package com.spring.hibernate.one_to_many.uni_directional;

import com.spring.hibernate.one_to_many.uni_directional.entity.Course;
import com.spring.hibernate.one_to_many.uni_directional.entity.Instructor;
import com.spring.hibernate.one_to_many.uni_directional.entity.InstructorDetail;
import com.spring.hibernate.one_to_many.uni_directional.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo {

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

            // Create a course.
            Course course = new Course("geometry");


            // Add some reviews.
            Review review1 = new Review("Nice subject");
            Review review2 = new Review("Need to learn again");

            // Add Reviews to Course
            course.addReview(review1);
            course.addReview(review2);

            // Save course.
            session.save(course);

            session.getTransaction().commit();
        }
    }
}
