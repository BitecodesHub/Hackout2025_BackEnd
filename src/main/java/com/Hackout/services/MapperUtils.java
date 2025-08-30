package com.Hackout.services;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperUtils {
    private final ModelMapper modelMapper = new ModelMapper();

    public <S, T> T map(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }
}