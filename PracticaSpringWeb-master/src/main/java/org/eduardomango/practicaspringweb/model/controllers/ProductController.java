package org.eduardomango.practicaspringweb.model.controllers;

import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.eduardomango.practicaspringweb.model.exceptions.ProductNotFoundException;
import org.eduardomango.practicaspringweb.model.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ProductEntity>> findAll(){
        return ResponseEntity.ok(ps.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> findById(Long id) throws ProductNotFoundException{
        return ResponseEntity.ok(ps.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductEntity> create(@RequestBody ProductEntity product){
        return ResponseEntity.status(HttpStatus.CREATED).body(ps.save(product));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> update(@PathVariable Long id,@RequestBody ProductEntity product){
        product.setId(id);
        ps.update(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping
    public ResponseEntity<ProductEntity> delete(@PathVariable Long id) throws ProductNotFoundException{
        ProductEntity p = ps.findById(id);
        ps.delete(p);
        return ResponseEntity.noContent().build();
    }
}
