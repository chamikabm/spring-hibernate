package com.spring.hibernate.mappings_demo;

import com.spring.hibernate.mappings_demo.entity.Instructor;
import com.spring.hibernate.mappings_demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("com/spring/hibernate/mappings_demo/hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .buildSessionFactory()
        ) {

            // When we are creating a new object it will be in transient state of the hibernate.
            Instructor instructor =
                    new Instructor("chamika", "kasun", "kasun@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("aa/youtube", "cricket");
            instructor.setInstructorDetail(instructorDetail);

            /*
                openSession (Session session = sessionFactory.openSession();)
                -----------
                 If we use this method, we need to flush() and close() the session.
                 It does not flush and close() automatically. We can use this method when
                 we decided to manage the Session our self.

                getCurrentSession (Session session = sessionFactory.getCurrentSession();)
                -----------------
                 A session is opened whenever getCurrentSession()
                 is called for the first time and closed when the transaction ends.
                 This creates a brand new session if one does not exist or uses an existing one if one already exists.
                 It automatically configured with both auto-flush and auto-close attributes as
                 true means Session will be automatically flushed and closed. We can use getCurrentSession()
                 method when our transaction runs long time.

                 getCurrentSession is usually sufficient. openSession provides and facilitates a greater
                 level of management of where the session is stored and managed. It's certainly an advanced option,
                 but one that does indeed fit the need of very clever developers
                 who are doing some nifty things with the session.
             */

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // When we save the entity it will goes to persistent state.
            session.save(instructor);

            session.getTransaction().commit();
        }
    }
}
