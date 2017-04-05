package com.dsr.myProject.app;


import com.dsr.myProject.model.User;
import com.dsr.myProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DbInit {

    @Autowired
    private UserService userService;

    @PostConstruct
    @Transactional
    public void init(){
        User user = new User();
        user.setName("vika");
        user.setPassword("123");
        userService.create(user);

    }
}