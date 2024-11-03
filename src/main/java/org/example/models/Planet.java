package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "planet")
public class Planet {
    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "fromPlanet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> fromTicketList = new ArrayList<>();

    @OneToMany(mappedBy = "toPlanet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> toTicketList = new ArrayList<>();
}
