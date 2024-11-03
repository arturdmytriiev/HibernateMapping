package org.example.service;

import org.example.config.HibernateConfig;
import org.example.dao.ClientDao;
import org.example.dao.PlanetDao;
import org.example.dao.TicketDao;
import org.example.models.Client;
import org.example.models.Planet;
import org.example.models.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserService {
    private ClientDao clientDao = new ClientDao();
    private PlanetDao planetDao = new PlanetDao();
    private TicketDao ticketDao = new TicketDao();
    private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    public void saveClient(Client client) {
        clientDao.save(client);
    }

    public void savePlanet(Planet planet) {
        planetDao.save(planet);
    }

    public void deleteClient(Client client) {
        clientDao.delete(client);
    }

    public void deletePlanet(Planet planet) {
        planetDao.delete(planet);
    }

    public Planet findByIdPlanet(String id) {
        return planetDao.get(id);
    }

    public Client findByIdClient(int id) {
        return clientDao.get(id);
    }

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public void updatePlanet(Planet planet) {
        planetDao.update(planet);
    }


    public void saveTicket(Ticket ticket) {
        ticketDao.save(ticket);
    }

    public void updateTicket(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public Ticket findByIdTicket(int id) {
        return ticketDao.get(id);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDao.delete(ticket);
    }

    public void saveTicketWithDependencies(Client client, Planet fromPlanet, Planet toPlanet, Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                clientDao.save(client);
                planetDao.save(fromPlanet);
                planetDao.save(toPlanet);

                ticket.setClient(client);
                ticket.setFromPlanet(fromPlanet);
                ticket.setToPlanet(toPlanet);

                ticketDao.save(ticket);
                transaction.commit();
                System.out.println("Ticket and dependencies saved successfully.");
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Failed to save ticket and dependencies: " + e.getMessage());
            }
        }

    }
}
