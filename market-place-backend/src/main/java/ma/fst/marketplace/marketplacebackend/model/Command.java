package com.madani.market_place.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateCommand;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

//    @ManyToMany(mappedBy = "commands") //TO.DO: another one!!
//    private List<Article> articles;
}
