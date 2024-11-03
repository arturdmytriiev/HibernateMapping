package org.example.launcher;


import org.example.models.Client;
import org.example.models.Planet;
import org.example.models.Ticket;
import org.example.service.UserService;
import org.h2.engine.User;

public class Launcher {
    public static void main(String[] args) {
        UserService userService = new UserService();

        Client client = new Client();
        client.setName("John Fariten");

        Planet fromPlanet = new Planet();
        fromPlanet.setId("EA");
        fromPlanet.setName("Earth");

        Planet toPlanet = new Planet();
        toPlanet.setId("MOO");
        toPlanet.setName("Moon");

        Ticket ticket = new Ticket();
        ticket.setCreatedAt("2024-11-03");

        userService.saveTicketWithDependencies(client, fromPlanet, toPlanet, ticket);
    }
}
