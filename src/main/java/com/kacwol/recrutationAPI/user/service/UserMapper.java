package com.kacwol.recrutationAPI.user.service;

import com.kacwol.recrutationAPI.user.data.MyUserDetails;
import com.kacwol.recrutationAPI.user.data.User;
import com.kacwol.recrutationAPI.user.data.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserMapper {

    private PasswordEncoder encoder;

    @Autowired
    public UserMapper(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public MyUserDetails toUserDetails(User user){
        return new MyUserDetails(user.getUserName(),user.getPassword(),user.getRoles());
    }
    public User toEntity(UserRegisterDto dto){
        return new User(dto.getUsername(), encoder.encode(dto.getPassword()), Set.of("ROLE_USER"));
    }
}
