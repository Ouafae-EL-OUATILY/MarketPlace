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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Label;

//    @OneToMany(mappedBy = "category") //TO.DO: check later if the mappedBy good for us or i have to delete it.
//    private List<Article> articles;
}
