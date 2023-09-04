package com.GestionDeStock.stock.Services;


import com.GestionDeStock.stock.DTO.AlertDTO;
import com.GestionDeStock.stock.DTO.ArticleDTO;
import com.GestionDeStock.stock.Entity.Alert;
import com.GestionDeStock.stock.Entity.Article;
import com.GestionDeStock.stock.Repository.AlertRepository;
import com.GestionDeStock.stock.Repository.ArticleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertServiceImpl implements AlertService{

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private AlertRepository alertRepository;

    @Transactional
    @Override
    public AlertDTO addalert(Alert alert, int idarticle) {

        Article article = articleRepository.findById(idarticle).orElse(null);
        article.setAlert(alert);
        articleRepository.save(article);
        Alert alert1 = alertRepository.save(alert);
        AlertDTO alertDTO =modelMapper.map(alert1 , AlertDTO.class) ;
        return alertDTO;
    }

    @Override
    public List<AlertDTO> gettallalert() {
        List<Alert> alerts = alertRepository.findAll();
        List<AlertDTO> alertDTOS = new ArrayList<>();
        for(Alert alert : alerts){

            AlertDTO alertDTO = modelMapper.map(alert , AlertDTO.class);
            ArticleDTO articleDTO = modelMapper.map(alert.getArticle() , ArticleDTO.class);
            alertDTO.setArticle(articleDTO);
            alertDTOS.add(alertDTO);
        }
        return alertDTOS;
    }

    @Transactional
    @Override
    public void deleteAlert(int alertId) {
        Alert alert = alertRepository.findById(alertId).orElse(null);
        if (alert != null) {
            Article article = alert.getArticle();
            if (article != null) {
                article.setAlert(null);
                articleRepository.save(article);
            }
            alertRepository.delete(alert);
        }
    }
}
