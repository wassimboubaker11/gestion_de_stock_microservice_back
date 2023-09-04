package com.GestionDeStock.stock.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GestionaireDTO {


    private Integer id;

    private String name;

    private String email;

    private String cin;

    private int tel;

    private String address;

    private String country;

    private String city;

    private String codePostal;

    private String dateOfBirthday;

    private String description;

    private String photo;

    private boolean valide ;



}
