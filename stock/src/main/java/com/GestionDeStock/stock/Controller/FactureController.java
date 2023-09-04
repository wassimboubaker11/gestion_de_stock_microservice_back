package com.GestionDeStock.stock.Controller;



import com.GestionDeStock.stock.DTO.FactureDTO;
import com.GestionDeStock.stock.Services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/stock")
public class FactureController {

    @Autowired
    private FactureService factureService;



    //  http://localhost:8081/api/v1/saveFacture/{idcommande}

    @PostMapping("/saveFacture/{idcommande}")
    public ResponseEntity<FactureDTO> saveFacture(@PathVariable ("idcommande") int idcommande){
        return ResponseEntity.ok(factureService.saveFacture( idcommande));
    }

    //  http://localhost:8081/api/v1/getFactureById/{idcommande}

    @GetMapping("/getFactureById/{idcommande}")
    public ResponseEntity<FactureDTO> getFactureById(@PathVariable ("idcommande") int idcommande){
        return ResponseEntity.ok(factureService.getFacturebyidcommande(idcommande));
    }
}
