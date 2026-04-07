package org.eduardomango.practicaspringweb.model.services;

import org.eduardomango.practicaspringweb.model.DTO.SaleRequestDTO;
import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.eduardomango.practicaspringweb.model.entities.SaleEntity;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.eduardomango.practicaspringweb.model.exceptions.ProductNotFoundException;
import org.eduardomango.practicaspringweb.model.exceptions.SaleNotFoundException;
import org.eduardomango.practicaspringweb.model.exceptions.UserNotFoundException;
import org.eduardomango.practicaspringweb.model.repositories.IRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SaleService {
    private final IRepository<SaleEntity> saleRepository;
    private final UserService us;
    private final ProductService ps;

    public SaleService (IRepository<SaleEntity> saleRepository,UserService us, ProductService ps){
        this.saleRepository=saleRepository;
        this.us=us;
        this.ps=ps;
    }

    public List<SaleEntity> findAll(){
        return saleRepository.findAll();
    }

    /**
     *
     * @param idProduct
     * @param idUser
     * @param quantity
     * @throws UserNotFoundException
     * @throws ProductNotFoundException
     */
    public SaleEntity save(Long idProduct,long idUser,Long quantity) throws UserNotFoundException, ProductNotFoundException {
        UserEntity user=us.findById(idUser);
        ProductEntity prod=ps.findById(idProduct);
        SaleEntity sale=SaleEntity.builder()
                .client(user)
                .products(prod)
                .quantity(quantity)
                .build();
        saleRepository.save(sale);
        return sale;
    }
    public SaleEntity save(SaleRequestDTO request) throws UserNotFoundException, ProductNotFoundException {
        UserEntity user=us.findById(request.getIdUser());
        ProductEntity prod=ps.findById(request.getIdProduct());
        SaleEntity sale=SaleEntity.builder()
                .client(user)
                .products(prod)
                .quantity(request.getQuantity())
                .build();
        saleRepository.save(sale);
        return sale;
    }
    public SaleEntity findById(Long id) throws SaleNotFoundException{
        return saleRepository.findAll()
                .stream().filter(sale->sale.getId()==id)
                .findFirst()
                .orElseThrow(SaleNotFoundException::new);
    }
    public void delete(Long id) throws SaleNotFoundException{
        SaleEntity sale=findById(id);
        saleRepository.delete(sale);
    }
    public SaleEntity update(Long id,SaleEntity modSale) throws SaleNotFoundException{
        SaleEntity sale=findById(id);
        modSale.setId(sale.getId());
        saleRepository.update(modSale);
        return modSale;
    }

}
