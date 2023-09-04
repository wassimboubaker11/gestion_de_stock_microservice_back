package com.GestionDeStock.stock.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Alert")
public class Alert implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idalert" )
    private int idalert ;

    private int quanityMuni;

    private int quanityMax;

    @OneToOne(mappedBy = "alert")
    private Article article;
}
