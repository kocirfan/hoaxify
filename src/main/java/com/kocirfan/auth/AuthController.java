package com.kocirfan.auth;

import com.fasterxml.jackson.annotation.JsonView;
import com.kocirfan.shared.CurrentUser;
import com.kocirfan.shared.Views;
import com.kocirfan.user.User;
import com.kocirfan.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/api/1.0/auth")
    @JsonView(Views.Base.class)
    ResponseEntity<?> handleAuthentication(@CurrentUser User user) {


        return ResponseEntity.ok(user);
    }

}
