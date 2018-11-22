package com.spring.hibernate.one_to_one;

import com.spring.hibernate.one_to_one.entity.Instructor;
import com.spring.hibernate.one_to_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("com/spring/hibernate/one_to_one/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()
        ) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            int instructorId = 2;
            Instructor instructor = session.get(Instructor.class, instructorId);

            // When we save the entity it will goes to Removed state.and will be garbage collected later.
            session.delete(instructor);

            session.getTransaction().commit();
        }
    }
}
