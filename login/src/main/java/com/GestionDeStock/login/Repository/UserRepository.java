package com.GestionDeStock.login.Repository;


import com.GestionDeStock.login.Entity.Role;
import com.GestionDeStock.login.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer> {

    Optional<User> findByEmail(String email);

    void  deleteByEmail(String email);

    User getUserByEmailAndRole(String email , Role role);
}