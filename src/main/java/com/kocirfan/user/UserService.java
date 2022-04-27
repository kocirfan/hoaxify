package com.kocirfan.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    //Veri tabanında sifre güvenliği için
    PasswordEncoder passwordEncoder;

    //@Autowired ==> bir classta sadece bir parametre alan constructor varsa bu anatasyona gerek yok
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void save(User user) {
        // user ın password'u passwordEncoder'ın encode metodu ile set edildi
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
