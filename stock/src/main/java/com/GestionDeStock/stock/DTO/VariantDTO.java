package com.GestionDeStock.stock.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VariantDTO {

    private int idvariant;

    private String nom;

    private int quantity;

    private List<SousOptionDTO> sousOptions;

    private String picture;

    private float prixvente;

}
