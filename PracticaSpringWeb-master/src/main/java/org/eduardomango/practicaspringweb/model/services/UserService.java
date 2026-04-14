package org.eduardomango.practicaspringweb.model.services;


import org.eduardomango.practicaspringweb.model.DTO.UserRequestDTO;
import org.eduardomango.practicaspringweb.model.entities.UserEntity;
import org.eduardomango.practicaspringweb.model.exceptions.UserNotFoundException;
import org.eduardomango.practicaspringweb.model.mappers.UserMapper;
import org.eduardomango.practicaspringweb.model.repositories.IRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final IRepository<UserEntity> userRepository;

    private final UserMapper mapper;

    public UserService(IRepository<UserEntity> userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    public UserEntity findById(long id) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(()->new UserNotFoundException("User with id= "+id+" not found"));
    }

    public UserEntity findByUsername(String username){
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    public UserEntity findByEmail(String email){
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    public UserEntity save(UserEntity user) {
        userRepository.save(user);
        return user;
    }
    public UserEntity save(UserRequestDTO user) {
        UserEntity newUser=mapper.toEntity(user);
        userRepository.save(newUser);
        return newUser;
    }

    public void delete(UserEntity user) {
        userRepository.delete(user);
    }

    public void update(UserEntity user) {
        userRepository.update(user);
    }
    public UserEntity update(Long id, UserRequestDTO user) {
        UserEntity original=findById(id);
        original.setUsername(user.getUsername());
        original.setPassword(user.getPassword());
        original.setEmail(user.getEmail());
        userRepository.update(original);
        return original;
    }
}
