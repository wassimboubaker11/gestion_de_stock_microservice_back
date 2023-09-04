package com.GestionDeStock.stock.Services;


import com.GestionDeStock.stock.DTO.SousOptionDTO;
import com.GestionDeStock.stock.Entity.Option;
import com.GestionDeStock.stock.Entity.SousOption;
import com.GestionDeStock.stock.Repository.OptionRepository;
import com.GestionDeStock.stock.Repository.Sous_OptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Sous_OptionServiceImpl implements Sous_OptionService{

    @Autowired
    private Sous_OptionRepository sous_optionRepository;

    @Autowired
    private OptionRepository optionRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public SousOptionDTO saveSousOption(SousOption sous_option, int idoption) {
        Option option = optionRepository.findById(idoption).get();



        SousOption sous_option1 = sous_optionRepository.save(sous_option);
        sous_option1.setOption(option);
        sous_optionRepository.save(sous_option1);


        SousOptionDTO sousOptionDTO = modelMapper.map(sous_option1 , SousOptionDTO.class);
        return sousOptionDTO;


    }

    @Override
    public List<SousOptionDTO> getAllSousOption() {
        List<SousOption> sousOptions = sous_optionRepository.findAll();
        List<SousOptionDTO> sousOptionDTOS = new ArrayList<>();
        for(SousOption sousOption : sousOptions){
            sousOptionDTOS.add(modelMapper.map(sousOption , SousOptionDTO.class));
        }
        return sousOptionDTOS;
    }

    @Override
    public List<SousOptionDTO> getSousOptionsbyidoption(int idoption) {
        List<SousOption> sousOptions = sous_optionRepository.getSousOptionsByOption(idoption);
        List<SousOptionDTO> sousOptionDTOS = new ArrayList<>();
        for(SousOption sousOption : sousOptions){
            SousOptionDTO sousOptionDTO = modelMapper.map(sousOption , SousOptionDTO.class);
            sousOptionDTOS.add(sousOptionDTO);
        }
        return sousOptionDTOS;
    }

    @Override
    public void deletesous_option(int idsous_option) {
        sous_optionRepository.deleteById(idsous_option);
    }


}
