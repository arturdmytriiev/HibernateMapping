package org.example.config;

import lombok.Data;
import org.example.models.Client;
import org.example.models.Planet;
import org.example.models.Ticket;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Data
public class HibernateConfig {
    private static final HibernateConfig INSTANCE;

    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateConfig();
    }

    private HibernateConfig() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();

        Flyway.configure()
                .dataSource("jdbc:h2:file:D:/H2_DATA/ORM","user","")
                .locations("db/migration")
                .load()
                .migrate();
    }
    public static HibernateConfig getInstance() {
        return INSTANCE;
    }

    public void close (){
        sessionFactory.close();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
