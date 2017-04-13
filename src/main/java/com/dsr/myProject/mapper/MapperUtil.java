package com.dsr.myProject.mapper;

import ma.glasnost.orika.MapperFacade;

import java.util.List;

public class MapperUtil {

    public static  List<?> map(final MapperFacade mapper, final List source, final Class<?> destType) {

        if (mapper == null || source == null) {
            return null;
        }
        List<?> dest = mapper.mapAsList(source, destType);
        return dest;
    }
}
