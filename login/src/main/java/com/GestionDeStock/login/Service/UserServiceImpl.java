package com.GestionDeStock.login.Service;


import com.GestionDeStock.login.DTO.UserDTO;
import com.GestionDeStock.login.Entity.Role;
import com.GestionDeStock.login.Entity.User;
import com.GestionDeStock.login.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{



    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
      return   userRepository.save(user);
    }

    @Override
    public UserDTO getuser(String email, Role role) {
        User user = userRepository.getUserByEmailAndRole(email , role);
        UserDTO userDTO = modelMapper.map(user , UserDTO.class);
        return userDTO;
    }

    @Transactional
    @Override
    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }
}
