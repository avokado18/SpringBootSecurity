package com.dsr.myProject.service;

import com.dsr.myProject.model.User;
import com.dsr.myProject.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User create(User user){
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword()  );
        return userRepository.save(newUser);
    }

    @Transactional
    public User findOne(){
        return getAll().get(0);
    }

    @Transactional
    public List<User> getAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Transactional
    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }

}
