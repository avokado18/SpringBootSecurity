package com.dsr.myProject.mapper;

import com.dsr.myProject.dto.UserDTO;
import com.dsr.myProject.model.User;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class UserUserDTOMapper extends CustomMapper<User, UserDTO> {
    @Override
    public void mapAtoB(User user, UserDTO userDto, MappingContext context) {
        userDto.setBirthdate(user.getBirthdate().getTime());
    }
}
