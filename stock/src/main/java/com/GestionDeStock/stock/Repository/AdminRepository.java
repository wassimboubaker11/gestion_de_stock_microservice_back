package com.GestionDeStock.stock.Repository;


import com.GestionDeStock.stock.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin getAdminByEmail(String email);
}
