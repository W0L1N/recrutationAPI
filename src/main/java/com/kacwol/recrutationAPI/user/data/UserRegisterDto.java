package com.kacwol.recrutationAPI.user.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRegisterDto {
    private String username;
    private String password;
}
