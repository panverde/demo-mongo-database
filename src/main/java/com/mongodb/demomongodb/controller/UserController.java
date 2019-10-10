package com.mongodb.demomongodb.controller;

import com.mongodb.demomongodb.model.User;
import com.mongodb.demomongodb.repository.IUserRepository;
import com.mongodb.demomongodb.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserServiceImpl service;

    private final IUserRepository userRepository;

    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "")
    public List<User> getAllUsers() {
        LOG.info("Getting all users.");
        return service.findAll();
    }

    @PostMapping(value = "/create")
    public User addNewUsers(@RequestBody User user) {
        LOG.info("Saving user.");
        return userRepository.save(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable String id){
        LOG.info("Delete user.");
        userRepository.deleteById(id);
    }



}
