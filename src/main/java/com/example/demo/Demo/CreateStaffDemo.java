/*
package com.example.demo.Demo;

import com.example.demo.Model.Staff;
import com.example.demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStaffDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Staff.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Staff staff = new Staff("amirmahdi", "chiti", "amir@gmail.com");

            session.beginTransaction();

            session.save(staff);

            session.getTransaction().commit();
        }finally{
            sessionFactory.close();
        }
    }
}
*/
