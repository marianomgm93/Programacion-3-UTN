package org.eduardomango.practicaspringweb.model.mappers;

import org.eduardomango.practicaspringweb.model.DTO.UserRequestDTO;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IMapper<UserEntity,UserRequestDTO> {

    @Autowired
    private ModelMapper userMapper;

    public UserEntity toEntity(UserRequestDTO dto){
       return userMapper.map(dto, UserEntity.class);
    }
    public UserRequestDTO toDTO(UserEntity entity){
        return userMapper.map(entity, UserRequestDTO.class);
    }
}
