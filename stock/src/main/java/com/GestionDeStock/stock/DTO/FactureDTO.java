package com.GestionDeStock.stock.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactureDTO {

    private int idFacture;

    private LocalDate dateFacture;

    private double ttc;

    private double ht;

    private double tva;

    private String totalLettre;

    private String reference;
}
