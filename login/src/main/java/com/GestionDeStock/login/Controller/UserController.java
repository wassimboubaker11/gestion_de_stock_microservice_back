package com.GestionDeStock.login.Controller;



import com.GestionDeStock.login.DTO.UserDTO;
import com.GestionDeStock.login.Entity.Role;
import com.GestionDeStock.login.Entity.User;
import com.GestionDeStock.login.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/login")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //  http://localhost:8081/api/v1/getuserbyemailandrole/{email}/{role}

    @GetMapping("/getuserbyemailandrole/{email}/{role}")
    public UserDTO getuserbyemailandrole(@PathVariable ("email") String email , @PathVariable Role role){
        return userService.getuser(email , role);
    }

    @DeleteMapping("/deleteUserByEmail/{email}")
    public void deleteUserByEmail (@PathVariable("email") String email){
        userService.deleteUserByEmail(email);
    }
}
