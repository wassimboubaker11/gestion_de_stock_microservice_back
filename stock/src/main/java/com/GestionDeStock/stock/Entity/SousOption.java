package com.GestionDeStock.stock.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Sous_option")
public class SousOption implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idsousoption")
    private int idsousoption;

    @Column(name = "Nom")
    private String nom;


    @ManyToOne
    private Option option;

    @JsonIgnore

    @ManyToMany(mappedBy = "sousOptions")

    private List<Variant> variants;
}
