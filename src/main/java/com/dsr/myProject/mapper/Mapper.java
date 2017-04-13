package com.dsr.myProject.mapper;

import com.dsr.myProject.dto.UserDTO;
import com.dsr.myProject.model.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(User.class, UserDTO.class)
                .exclude("enabled")
                .byDefault()
                .register();
    }
}
