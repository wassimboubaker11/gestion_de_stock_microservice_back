package com.GestionDeStock.stock.Services;



import com.GestionDeStock.stock.DTO.CategoryDTO;
import com.GestionDeStock.stock.Entity.Category;

import java.util.List;

public interface CategoryService {

    CategoryDTO savecategory (Category category);

    List<CategoryDTO> getAllcategory();

    void deletecategory(int idcategory);

    CategoryDTO getcategorybyid(int idcategory);

    CategoryDTO updateCategory(Category category , int idcategory);


}
