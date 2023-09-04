package com.GestionDeStock.stock.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlertDTO {

    private int idalert ;

    private int quanityMuni;

    private int quanityMax;

    private ArticleDTO article;
}
