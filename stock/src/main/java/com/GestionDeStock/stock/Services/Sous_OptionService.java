package com.GestionDeStock.stock.Services;



import com.GestionDeStock.stock.DTO.SousOptionDTO;
import com.GestionDeStock.stock.Entity.SousOption;

import java.util.List;

public interface Sous_OptionService {

        SousOptionDTO saveSousOption(SousOption sous_option , int idoption);

        List<SousOptionDTO> getAllSousOption();

        List<SousOptionDTO> getSousOptionsbyidoption(int idoption);

        void deletesous_option(int idsous_option);
}
