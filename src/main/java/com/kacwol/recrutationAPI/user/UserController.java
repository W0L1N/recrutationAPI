package com.kacwol.recrutationAPI.user;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/admin")
@Secured({"ROLE_ADMIN"})
public class UserController {
}
