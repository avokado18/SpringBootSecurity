package com.dsr.myProject.repository;

import com.dsr.myProject.model.Role;
import org.h2.command.ddl.CreateUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    List<String> findByUsername(String username);
}
