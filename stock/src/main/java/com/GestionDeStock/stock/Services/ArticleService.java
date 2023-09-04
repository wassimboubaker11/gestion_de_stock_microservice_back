package com.GestionDeStock.stock.Services;



import com.GestionDeStock.stock.DTO.ArticleDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ArticleService {

    ArticleDTO savearticle(String article , int iddepot , int idcategory , MultipartFile picture) throws IOException;


    ArticleDTO saveearticle(String article  , MultipartFile picturee) throws IOException;

    List<ArticleDTO> getAllArticle();

    void deletearticle(int idartilce);

    ArticleDTO updatearticle(int idarticle, String article , MultipartFile picture)throws IOException;


    ArticleDTO getarticlebyid(int idarticle);

    List<ArticleDTO> getallarticlebyiddepot(int iddepot);


    List<ArticleDTO> getAllArticlewithOutAlert();

}
