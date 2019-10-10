package com.mongodb.demomongodb.service.impl;

import com.mongodb.demomongodb.model.User;
import com.mongodb.demomongodb.repository.IUserRepository;
import com.mongodb.demomongodb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserService userService;

    public List<User> findAll() {
        return userRepository.findAll();
    }


}
