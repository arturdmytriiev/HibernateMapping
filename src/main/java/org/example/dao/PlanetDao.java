package org.example.dao;

import org.example.config.HibernateConfig;
import org.example.models.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetDao {
    private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    public void save (Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(planet);
            transaction.commit();
        }
    }

    public void delete (Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(planet);
            transaction.commit();
        }
    }

    public Planet get (String id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void update (Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(planet);
            transaction.commit();
        }
    }
}
