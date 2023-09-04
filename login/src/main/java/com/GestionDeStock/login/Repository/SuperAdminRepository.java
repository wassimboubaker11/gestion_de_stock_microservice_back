package com.GestionDeStock.login.Repository;


import com.GestionDeStock.login.Entity.Super_Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperAdminRepository extends JpaRepository<Super_Admin, Integer> {
}
