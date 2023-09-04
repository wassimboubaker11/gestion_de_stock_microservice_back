package com.GestionDeStock.stock.Services;


import com.GestionDeStock.stock.DTO.MVTDTO;

import java.util.List;

public interface MVTService {

    List<MVTDTO> getAllMVTbyIdCommande(int idcommande);

    List<MVTDTO> getAllMVT();
}
