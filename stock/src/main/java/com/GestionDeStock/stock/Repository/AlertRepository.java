package com.GestionDeStock.stock.Repository;


import com.GestionDeStock.stock.Entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Integer> {


}
