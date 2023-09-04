package com.GestionDeStock.stock.DTO;



import com.GestionDeStock.stock.Entity.Type1;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MVTDTO {

    private int idmvt;

    private String nomVariant;

    private int quantity;

    private Type1 type1;

    private ArticleDTO articleDTO;

    private CommandeDTO commandeDTO;
}
