package com.kocirfan.auth;

import com.fasterxml.jackson.annotation.JsonView;
import com.kocirfan.shared.CurrentUser;
import com.kocirfan.shared.Views;
import com.kocirfan.user.User;
import com.kocirfan.user.UserRepository;
import com.kocirfan.error.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/api/1.0/auth")
    @JsonView(Views.Base.class)
    ResponseEntity<?> handleAuthentication(@CurrentUser User user){

        //User user = (User) authentication.getPrincipal();

//       String base64encoded = authorization.split("Basic ")[1]; //dxN1cjE6UDR
//       String decoded = new String(Base64.getDecoder().decode(base64encoded)); //user1:P4ssword
//       String[] parts = decoded.split(":"); //["user1", "P4ssword]
//       String username = parts[0];
//       User inDB = userRepository.findByUsername(username);

       return ResponseEntity.ok(user);
    }

}
