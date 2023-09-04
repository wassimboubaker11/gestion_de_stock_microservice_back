package com.GestionDeStock.stock.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDTO {

    private int idcommande;

    private int quantite;

    private String nom;
    private Float montant;

    private LocalDateTime date;

    private TierDTO tier;

    private List<MVTDTO> mvtList;

    private FactureDTO factureDTO;
}
