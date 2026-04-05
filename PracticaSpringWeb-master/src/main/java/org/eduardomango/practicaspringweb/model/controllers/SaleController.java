package org.eduardomango.practicaspringweb.model.controllers;

import org.eduardomango.practicaspringweb.model.entities.SaleEntity;
import org.eduardomango.practicaspringweb.model.exceptions.SaleNotFoundException;
import org.eduardomango.practicaspringweb.model.services.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private final SaleService ss;
    public SaleController(SaleService ss){
        this.ss=ss;
    }

    @GetMapping
    public List<SaleEntity> findAll(){
        return ss.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<SaleEntity> findById(@PathVariable Long id) throws SaleNotFoundException {
        SaleEntity sale=ss.findById(id);
        return ResponseEntity.ok(sale);
    }
    @PostMapping
    public ResponseEntity<SaleEntity> create(@RequestBody SaleEntity se){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ss.save(se.getProducts().getId(),se.getClient().getId(), se.getQuantity()));
    }
    @PutMapping("{/id}")
    public ResponseEntity<SaleEntity> update(@PathVariable Long id, @RequestBody SaleEntity sale) throws SaleNotFoundException{
        return ResponseEntity.ok(ss.update(id,sale));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<SaleEntity> delete(@PathVariable Long id) throws SaleNotFoundException{
        ss.delete(id);
        return ResponseEntity.noContent().build();
    }

}
