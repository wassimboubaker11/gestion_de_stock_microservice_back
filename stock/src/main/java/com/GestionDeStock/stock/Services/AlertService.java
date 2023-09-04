package com.GestionDeStock.stock.Services;


import com.GestionDeStock.stock.DTO.AlertDTO;
import com.GestionDeStock.stock.Entity.Alert;

import java.util.List;

public interface AlertService {

    AlertDTO addalert(Alert alert, int idarticle);

    List<AlertDTO> gettallalert();

    void deleteAlert(int idalert);
}
