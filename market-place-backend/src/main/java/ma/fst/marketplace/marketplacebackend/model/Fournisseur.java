package com.madani.market_place.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String adresse;

//    @ManyToMany(mappedBy = "fournisseurs") //TO.DO: check later if the mappedBy good for us or not
//    private List<Store> stores;
}
