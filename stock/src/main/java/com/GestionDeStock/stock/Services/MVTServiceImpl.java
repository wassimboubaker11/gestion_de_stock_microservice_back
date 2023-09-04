package com.GestionDeStock.stock.Services;


import com.GestionDeStock.stock.DTO.ArticleDTO;
import com.GestionDeStock.stock.DTO.CommandeDTO;
import com.GestionDeStock.stock.DTO.MVTDTO;
import com.GestionDeStock.stock.Entity.MVT;
import com.GestionDeStock.stock.Repository.MVTRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MVTServiceImpl implements MVTService{

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private MVTRepository mvtRepository;


    @Override
    public List<MVTDTO> getAllMVTbyIdCommande(int idcommande) {
                List<MVT> mvts =mvtRepository.findMVTByIdcommande(idcommande);
                List<MVTDTO> mvtdtos=new ArrayList<>();
                for(MVT mvt : mvts){
                    MVTDTO mvtDTO = modelMapper.map(mvt , MVTDTO.class);
                    mvtDTO.setArticleDTO(modelMapper.map(mvt.getArticle() , ArticleDTO.class));
                    mvtDTO.setCommandeDTO(modelMapper.map(mvt.getCommande() , CommandeDTO.class));
                    mvtdtos.add(mvtDTO);
                }
                return mvtdtos;
    }

    @Override
    public List<MVTDTO> getAllMVT() {
        List<MVT> mvts = mvtRepository.findAll();
        List<MVTDTO> mvtdtos=new ArrayList<>();
        for(MVT mvt:mvts){
            CommandeDTO commandeDTO=modelMapper.map(mvt.getCommande() , CommandeDTO.class);
            ArticleDTO articleDTO = modelMapper.map(mvt.getArticle() , ArticleDTO.class);
            MVTDTO mvtdto = modelMapper.map(mvt , MVTDTO.class);
            mvtdto.setArticleDTO(articleDTO);
            mvtdto.setCommandeDTO(commandeDTO);
            mvtdtos.add(mvtdto);
        }
        return mvtdtos;
    }
}
