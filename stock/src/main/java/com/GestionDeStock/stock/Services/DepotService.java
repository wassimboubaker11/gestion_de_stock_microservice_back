package com.GestionDeStock.stock.Services;



import com.GestionDeStock.stock.DTO.DepotDTO;
import com.GestionDeStock.stock.Entity.Depot;

import java.util.List;

public interface DepotService {


    DepotDTO savedepot(Depot d);

    void deletedepot(int iddepot);

    DepotDTO updatedepot(Depot d , int iddepot);

    List<DepotDTO> getalldepot();

    DepotDTO getdepotbyid(int iddepot);
}
