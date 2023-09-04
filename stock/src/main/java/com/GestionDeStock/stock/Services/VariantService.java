package com.GestionDeStock.stock.Services;



import com.GestionDeStock.stock.DTO.VariantDTO;

import java.util.List;

public interface VariantService {

     VariantDTO addVariant(List<Integer> sousOptionIds, int articleId , int quantity, String nom);

     List<VariantDTO> getVariantbyarticle(int idarticle);

     void deletevariant(int idvariant);
}
