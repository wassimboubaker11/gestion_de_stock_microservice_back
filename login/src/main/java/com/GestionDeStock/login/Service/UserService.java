package com.GestionDeStock.login.Service;


import com.GestionDeStock.login.DTO.UserDTO;
import com.GestionDeStock.login.Entity.Role;
import com.GestionDeStock.login.Entity.User;

public interface UserService {


    User createUser(User user);

    UserDTO getuser(String email , Role role);

    void deleteUserByEmail(String email);
}
