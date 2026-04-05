package org.eduardomango.practicaspringweb.model.controllers;

import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.eduardomango.practicaspringweb.model.exceptions.ProductNotFoundException;
import org.eduardomango.practicaspringweb.model.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService ps;

    public ProductController(ProductService ps){
        this.ps=ps;
    }
    @GetMapping
    public List<ProductEntity> findAll(){
        return ps.findAll();
    }

    @GetMapping("/{id}")
    public ProductEntity findById(Long id) throws ProductNotFoundException{
        return ps.findById(id);
    }

    @PostMapping
    public void create(@RequestBody ProductEntity product){
        ps.save(product);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody ProductEntity product){
        product.setId(id);
        ps.update(product);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) throws ProductNotFoundException{
        ProductEntity p = ps.findById(id);
        ps.delete(p);
    }
}
