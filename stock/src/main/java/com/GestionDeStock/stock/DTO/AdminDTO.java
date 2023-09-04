package com.GestionDeStock.stock.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {

    private Integer id;
    private String name;
    private String email;
    private String tel;
    private String adresse;
    private String site;
    private String logo;
    private boolean valide;




}

