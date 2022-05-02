package com.kacwol.recrutationAPI.user.service;

import com.kacwol.recrutationAPI.user.data.User;

import java.util.List;

public interface UserService {
    User getUserByName(String name);
    User getUserById(Long id);
    List<User> getAllUsers();


}
