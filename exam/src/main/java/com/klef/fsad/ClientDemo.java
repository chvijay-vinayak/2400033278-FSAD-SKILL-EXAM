package com.klef.fsad;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class ClientDemo
{
    public static void main(String[] args)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        // Insert records
        Booking b1 = new Booking("Akhil","2026-03-13","Confirmed");
        Booking b2 = new Booking("Rahul","2026-03-14","Pending");

        session.persist(b1);
        session.persist(b2);

        session.getTransaction().commit();

        // HQL Query without WHERE
        session.beginTransaction();

        Query<Booking> q = session.createQuery("from Booking",Booking.class);

        List<Booking> list = q.list();

        for(Booking b:list)
        {
            System.out.println(b.getId()+" "+b.getName()+" "+b.getDate()+" "+b.getStatus());
        }

        session.getTransaction().commit();
        session.close();
    }
}