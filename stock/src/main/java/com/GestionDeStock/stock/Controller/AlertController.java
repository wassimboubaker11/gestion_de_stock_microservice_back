package com.GestionDeStock.stock.Controller;



import com.GestionDeStock.stock.DTO.AlertDTO;
import com.GestionDeStock.stock.Entity.Alert;
import com.GestionDeStock.stock.Services.AlertService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1/stock")
@RestController
public class AlertController {

    @Autowired
    private AlertService alertService;

    //  http://localhost:8081/api/v1/addalert/{idarticle}

    @PostMapping("/addalert/{idarticle}")
    public AlertDTO addalert(@RequestBody Alert alert , @PathVariable("idarticle") int idarticle){
        return  alertService.addalert(alert , idarticle);
    }


    //  http://localhost:8081/api/v1/getAllalert

    @GetMapping("/getAllalert")
    public List<AlertDTO> getAllalert(){
        return alertService.gettallalert();
    }

    // http://localhost:8081/api/v1/deletealertbyid/{idalert}


    @DeleteMapping("/deletealertbyid/{idalert}")
    public void deletealertbyid(@PathVariable ("idalert") int idalert){
        alertService.deleteAlert(idalert);
    }
}
