package com.klef.fsad;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
    private static SessionFactory sessionFactory;

    static
    {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Booking.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}