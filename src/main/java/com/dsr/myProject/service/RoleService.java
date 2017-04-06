package com.dsr.myProject.service;

import com.dsr.myProject.model.Role;
import com.dsr.myProject.model.User;
import com.dsr.myProject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public Role create(Role role){
        Role newRole = new Role();
        newRole.setUsername(role.getUsername());
        newRole.setRole(role.getRole()  );
        return roleRepository.save(newRole);
    }
}
