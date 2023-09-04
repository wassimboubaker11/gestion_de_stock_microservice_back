package com.GestionDeStock.stock.DTO;


import com.GestionDeStock.stock.Entity.Option;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SousOptionDTO {

    private int idsousoption;

    private String nom;

    private Option option;

   // private List<Variant> variants;


}
