package com.kocirfan.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    //Veri tabanında sifre güvenliği için
    PasswordEncoder passwordEncoder;

    //@Autowired ==> bir classta sadece bir parametre alan constructor varsa bu anatasyona gerek yok
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user) {
        // user ın password'u passwordEncoder'ın encode metodu ile set edildi
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }

    //Database'den veriyi parça parça almak
//    public Page<User> getUsers(Pageable page){
//        return userRepository.findAll(page);
//    }

    //Projection ile Database'den veriyi çekerken belirlediğimiz fieldlar görünür implementation
    public Page<UserProjection> getUsers(Pageable page){
        return userRepository.getAllUsersProjection(page);
    }
}
