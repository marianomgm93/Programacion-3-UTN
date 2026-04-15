package org.eduardomango.practicaspringweb.model.services;

import org.eduardomango.practicaspringweb.model.DTO.ProductRequestDTO;
import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.eduardomango.practicaspringweb.model.exceptions.ProductNotFoundException;
import org.eduardomango.practicaspringweb.model.mappers.ProductMapper;
import org.eduardomango.practicaspringweb.model.repositories.IRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductMapper mapper;
    private final IRepository<ProductEntity> productRepository;

    public ProductService(ProductMapper mapper, IRepository<ProductEntity> productRepository) {
        this.mapper = mapper;
        this.productRepository = productRepository;
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public ProductEntity findById(long id) {
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product id= " + id + " not found"));
    }

    public ProductEntity findByName(String name) {
        return productRepository.findAll()
                .stream()
                .filter(prod -> prod.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product " + name + " not found"));
    }

    public List<ProductEntity> findMoreExpensiveThan(Double price) {
        return productRepository.findAll()
                .stream()
                .filter(user -> user.getPrice() > price)
                .toList();
    }

    public ProductEntity save(ProductEntity p) {
        productRepository.save(p);
        return p;
    }

    public ProductEntity save(ProductRequestDTO p) {
        ProductEntity product=mapper.toEntity(p);

        productRepository.save(product);
        return product;
    }

    public void delete(ProductEntity p) throws ProductNotFoundException {
        productRepository.delete(p);
    }

    public void update(ProductEntity p) {

        productRepository.update(p);
    }
    public ProductEntity update(Long id, ProductRequestDTO p) {
        ProductEntity product=findById(id);
        product.setName(p.getName());
        product.setPrice(p.getPrice());
        product.setDescription(p.getDescription());
        productRepository.update(product);
        return product;
    }
}
