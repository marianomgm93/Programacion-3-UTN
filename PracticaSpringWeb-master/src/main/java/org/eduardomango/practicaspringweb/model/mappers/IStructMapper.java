package org.eduardomango.practicaspringweb.model.mappers;

import org.eduardomango.practicaspringweb.model.DTO.ProductRequestDTO;
import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IStructMapper {

    ProductRequestDTO toDTO(ProductEntity p);
    ProductEntity toEntity(ProductRequestDTO pDTO);
}
