package com.kacwol.recrutationAPI.user.service;

import com.kacwol.recrutationAPI.user.data.User;
import com.kacwol.recrutationAPI.user.data.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUserByName(String name) {
        return userRepo.findByUserName(name).orElseThrow(()-> new UserNotFoundException());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(()-> new UserNotFoundException());
    }
}
