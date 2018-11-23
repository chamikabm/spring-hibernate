package com.spring.hibernate.many_to_many;

import com.spring.hibernate.many_to_many.entity.Course;
import com.spring.hibernate.many_to_many.entity.Instructor;
import com.spring.hibernate.many_to_many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("com/spring/hibernate/many_to_many/hibernate.cfg.xml")
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

            // Create some courses.
            Course course1 = new Course("physics");
            Course course2 = new Course("maths");

            // Add courses to instructor.
            instructor.addCourse(course1);
            instructor.addCourse(course2);

            // Save courses
            session.save(course1);
            session.save(course2);

            // We don`t need to save the instructor as this is a bi-directional relationship.

            session.getTransaction().commit();
        }
    }
}
