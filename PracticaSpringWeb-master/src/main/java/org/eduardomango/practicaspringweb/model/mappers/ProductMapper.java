package org.eduardomango.practicaspringweb.model.mappers;

import org.eduardomango.practicaspringweb.model.DTO.ProductRequestDTO;
import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements IMapper<ProductEntity, ProductRequestDTO> {
    @Autowired
    private ModelMapper mapper;
    @Override
    public ProductEntity toEntity(ProductRequestDTO productRequestDTO) {
        return mapper.map(productRequestDTO,ProductEntity.class);
    }

    @Override
    public ProductRequestDTO toDTO(ProductEntity productEntity) {
        return mapper.map(productEntity,ProductRequestDTO.class);
    }
}
