package org.eduardomango.practicaspringweb.model.mappers;

import org.eduardomango.practicaspringweb.model.DTO.SaleRequestDTO;
import org.eduardomango.practicaspringweb.model.entities.SaleEntity;
import org.eduardomango.practicaspringweb.model.repositories.SaleRepository;
import org.eduardomango.practicaspringweb.model.services.ProductService;
import org.eduardomango.practicaspringweb.model.services.UserService;

import java.time.LocalDate;

public class SaleMapper implements IMapper <SaleEntity, SaleRequestDTO> {
    private SaleRepository saleRepository;
    private UserService us;
    private ProductService ps;
    @Override
    public SaleEntity toEntity(SaleRequestDTO saleRequestDTO) {
        return  SaleEntity.builder()
                .id(saleRepository.findAll().getLast().getId()+1)
                .client(us.findById(saleRequestDTO.getIdUser()))
                .products(ps.findById(saleRequestDTO.getIdProduct()))
                .quantity(saleRequestDTO.getQuantity())
                .saleDate(LocalDate.now())
                .build();
    }

    @Override
    public SaleRequestDTO toDTO(SaleEntity saleEntity) {
        return SaleRequestDTO.builder()
                .idUser(saleEntity.getClient().getId())
                .idProduct(saleEntity.getProducts().getId())
                .quantity(saleEntity.getQuantity())
                .build();
    }
}
