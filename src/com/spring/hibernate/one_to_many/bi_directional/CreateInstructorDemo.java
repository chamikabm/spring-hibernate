package com.spring.hibernate.one_to_many.bi_directional;

import com.spring.hibernate.one_to_many.bi_directional.entity.Course;
import com.spring.hibernate.one_to_many.bi_directional.entity.Instructor;
import com.spring.hibernate.one_to_many.bi_directional.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("com/spring/hibernate/one_to_one/hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .buildSessionFactory()
        ) {

            // When we are creating a new object it will be in transient state of the hibernate.
            Instructor instructor =
                    new Instructor("bob", "marley", "bob@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("aa/youtube", "music");
            instructor.setInstructorDetail(instructorDetail);

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // When we save the entity it will goes to persistent state.
            session.save(instructor);

            session.getTransaction().commit();
        }
    }
}
