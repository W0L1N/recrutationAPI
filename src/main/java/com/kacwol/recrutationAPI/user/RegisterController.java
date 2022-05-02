package com.kacwol.recrutationAPI.user;

import com.kacwol.recrutationAPI.user.data.UserRegisterDto;
import com.kacwol.recrutationAPI.user.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private RegisterService service;

    @Autowired
    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity register(@RequestBody UserRegisterDto dto){
        return service.register(dto);
    }
}
