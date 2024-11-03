package org.example.dao;

import org.example.config.HibernateConfig;
import org.example.models.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketDao {
    private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    public void save (Ticket ticket) {
        validate(ticket);
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        }
    }

    public void delete (Ticket ticket) {
        validate(ticket);
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(ticket);
            transaction.commit();
        }
    }

    public Ticket get(int id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public void update (Ticket ticket) {
        validate(ticket);
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        }
    }



    private void validate(Ticket ticket) {
        if(ticket.getClient() == null || ticket.getClient().getId() == null)
        {
            throw new IllegalArgumentException("Invalid or non-existent client.");
        }
        if(ticket.getFromPlanet() == null || ticket.getFromPlanet().getId() == null)
        {
            throw new IllegalArgumentException("Invalid or non-existent from planet.");
        }
        if(ticket.getToPlanet() == null || ticket.getToPlanet().getId() == null)
        {
            throw new IllegalArgumentException("Invalid or non-existent from planet.");
        }
    }
}
