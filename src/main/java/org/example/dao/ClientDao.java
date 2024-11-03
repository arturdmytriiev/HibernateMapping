package org.example.dao;

import org.example.config.HibernateConfig;
import org.example.models.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientDao {
    private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    public void save (Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    public void delete (Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }

    public Client get (int id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void update (Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }
}
