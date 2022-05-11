package com.kocirfan.auth;

import com.fasterxml.jackson.annotation.JsonView;
import com.kocirfan.shared.CurrentUser;
import com.kocirfan.user.User;
import com.kocirfan.user.UserRepository;
import com.kocirfan.user.vm.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/api/1.0/auth")
    UserVM handleAuthentication(@CurrentUser User user) {
        return new UserVM(user);
    }

}
