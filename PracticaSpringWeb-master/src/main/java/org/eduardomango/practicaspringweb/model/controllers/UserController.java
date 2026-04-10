package org.eduardomango.practicaspringweb.model.controllers;

import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.eduardomango.practicaspringweb.model.DTO.UserRequestDTO;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.eduardomango.practicaspringweb.model.exceptions.UserNotFoundException;
import org.eduardomango.practicaspringweb.model.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService us;

    public UserController(UserService us) {
        this.us = us;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        return ResponseEntity.ok(us.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable long id) throws UserNotFoundException {
        return ResponseEntity.ok(us.findById(id));
    }
    @GetMapping("/search/username")
    public ResponseEntity<UserEntity> findByUsername(@RequestParam String username){
        return ResponseEntity.ok(us.findByUsername(username));
    }
    @GetMapping("/search/email")
    public ResponseEntity<UserEntity> findByEmail(@RequestParam String email){
        return ResponseEntity.ok(us.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<UserEntity> create(@Valid @RequestBody UserRequestDTO user){
        return ResponseEntity.status(HttpStatus.CREATED).body(us.save(user));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> update(@PathVariable long id, @Valid @RequestBody UserRequestDTO user) throws UserNotFoundException{
        return ResponseEntity.ok(us.update(id,user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> delete(@PathVariable long id) throws UserNotFoundException{
        UserEntity ue=us.findById(id);
        us.delete(ue);
        return ResponseEntity.noContent().build();
    }

}
