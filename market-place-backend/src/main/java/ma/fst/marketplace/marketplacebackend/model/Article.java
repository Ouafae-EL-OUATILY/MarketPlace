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
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    // FIXME: to check later if the datatype is correct or not
    private String pu;

//    @ManyToMany(mappedBy = "articles") //TO.DO: other mappedBy
//    private List<Store> stores;

    @ManyToMany
    @JoinTable(
            name = "article_command",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "command_id")
    )
    private List<Command> commands;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
}
