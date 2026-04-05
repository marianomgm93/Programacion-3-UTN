package org.eduardomango.practicaspringweb.model.controllers;

import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.eduardomango.practicaspringweb.model.exceptions.UserNotFoundException;
import org.eduardomango.practicaspringweb.model.services.UserService;
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
    public List<UserEntity> findAll() {
        return us.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity findById(@PathVariable long id) throws UserNotFoundException {
        return us.findById(id);
    }
    @PostMapping
    public void create(@RequestBody UserEntity user){
        us.save(user);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody UserEntity user) throws UserNotFoundException{
        user.setId(id);
        us.update(user);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) throws UserNotFoundException{
        UserEntity ue=findById(id);
        us.delete(ue);
    }

}
