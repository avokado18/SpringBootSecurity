package com.dsr.myProject.app;


import com.dsr.myProject.model.Role;
import com.dsr.myProject.model.User;
import com.dsr.myProject.model.Word;
import com.dsr.myProject.repository.RoleRepository;
import com.dsr.myProject.service.RoleService;
import com.dsr.myProject.service.UserService;
import com.dsr.myProject.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DbInit {

    @Autowired
    private UserService userService;
    @Autowired
    private WordsService wordsService;
    @Autowired
    private RoleService roleService;

    @PostConstruct
    @Transactional
    public void init(){
        User user = new User();
        user.setName("vika");
        user.setPassword("123");
        userService.create(user);
        user.setName("user");
        user.setPassword("password");
        userService.create(user);
        Word word = new Word();
        word.setOriginal("привет");
        word.setTranslated("hello");
        wordsService.create(word);
        Role role = new Role();
        role.setUsername("vika");
        role.setRole("ROLE_ADMIN");
        roleService.create(role);
    }
}