package com.kacwol.recrutationAPI.user.service;

import com.kacwol.recrutationAPI.user.data.User;
import com.kacwol.recrutationAPI.user.data.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Autowired
    public RegisterService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public ResponseEntity register(UserRegisterDto userDto){
        if(userRepo.findByUserName(userDto.getUsername()).isPresent()){
            return new ResponseEntity("User already exists", HttpStatus.BAD_REQUEST);
        }
        User user = userMapper.toEntity(userDto);
        userRepo.save(user);
        return new ResponseEntity("User registered",HttpStatus.OK);
    }
}
