package com.test.demo.service;

import com.test.demo.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUser(String username);
    UserDTO addUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(String username);

}
