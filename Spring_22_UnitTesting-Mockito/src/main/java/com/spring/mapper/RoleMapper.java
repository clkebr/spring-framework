package com.spring.mapper;

import com.spring.dto.RoleDTO;
import com.spring.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

   private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    //convertToEntity
    public Role convertToEntity(RoleDTO dto){

        return modelMapper.map(dto,Role.class);
    }

    //convertToDto
    public RoleDTO convertToDto(Role entity){

        return modelMapper.map(entity,RoleDTO.class);
    }
}
