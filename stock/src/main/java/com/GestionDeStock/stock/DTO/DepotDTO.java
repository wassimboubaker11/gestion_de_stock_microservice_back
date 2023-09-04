package com.GestionDeStock.stock.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepotDTO {

    private int iddepot;

    private String nom;

    private String adresse;

    private int numero;

    private String datecreation;

    // private List<ArticleDTO> article;


}
