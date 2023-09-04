package com.GestionDeStock.stock.Services;




import com.GestionDeStock.stock.DTO.OptionDTO;
import com.GestionDeStock.stock.Entity.Option;

import java.util.List;

public interface OptionService {

    OptionDTO saveoption(Option o);

    List<OptionDTO> getAlloption();

    void deleteoption(int idoption);

    OptionDTO getOptionByID(int idoption);

    OptionDTO updateOption(Option option , int idoption);
}
