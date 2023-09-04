package com.GestionDeStock.stock.Services;


import com.GestionDeStock.stock.DTO.FactureDTO;

public interface FactureService {

    FactureDTO saveFacture(int idcommande);

    FactureDTO getFacturebyidcommande(int idcommande);
}
