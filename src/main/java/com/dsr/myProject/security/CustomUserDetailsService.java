package com.dsr.myProject.security;


import com.dsr.myProject.model.User;
import com.dsr.myProject.repository.RoleRepository;
import com.dsr.myProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository userRolesRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository,RoleRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository=userRolesRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByName(username);
        if(null == user){
            throw new UsernameNotFoundException("No user present with username: " + username);
        }else{
            List<String> userRoles=userRolesRepository.findByUsername(username);
        return new CustomUserDetails(user,userRoles);
        }
    }
}