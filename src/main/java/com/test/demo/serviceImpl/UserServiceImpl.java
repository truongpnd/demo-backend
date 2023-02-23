package com.test.demo.serviceImpl;

import com.test.demo.dto.UserDTO;
import com.test.demo.entity.Users;
import com.test.demo.repo.UsersRepo;
import com.test.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> user = usersRepo.findAll().stream().map(userEntity -> modelMapper.map(userEntity, UserDTO.class)).collect(Collectors.toList());
        return user;
    }

    @Override
    public UserDTO getUser(String username) {
        UserDTO user = modelMapper.map(usersRepo.findById(username).get(), UserDTO.class);
        return user;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        Users user = modelMapper.map(userDTO, Users.class);
        usersRepo.save(user);
        return userDTO;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        Users user = modelMapper.map(userDTO, Users.class);
        usersRepo.save(user);
        return userDTO;
    }

    @Override
    public void deleteUser(String username) {
        usersRepo.deleteById(username);
    }
}
