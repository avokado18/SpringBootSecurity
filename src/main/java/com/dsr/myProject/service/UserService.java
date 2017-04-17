package com.dsr.myProject.service;

import com.dsr.myProject.dto.UserDTO;
import com.dsr.myProject.mapper.Mapper;
import com.dsr.myProject.model.User;
import com.dsr.myProject.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    @Transactional
    public UserDTO create(User user){
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword()  );
        newUser.setBirthdate(user.getBirthdate());
        return mapper.map(userRepository.save(newUser), UserDTO.class);
    }

    @Transactional
    public List<UserDTO> getAll() {
        ArrayList<User> users = Lists.newArrayList(userRepository.findAll());
        return mapper.mapAsList(users, UserDTO.class);
    }

    @Transactional
    public UserDTO findByName(String name){
        return mapper.map(userRepository.findByName(name), UserDTO.class);
    }

}
