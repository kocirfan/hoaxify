package com.kocirfan;

import com.kocirfan.user.User;
import com.kocirfan.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class HoaxifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoaxifyApplication.class, args);
    }

    @Bean
    CommandLineRunner createInitialUsers(UserService userService) {
        return (args) -> {
            User user = new User();
            user.setUsername("user1");
            user.setDisplayName("display1");
            user.setPassword("P4ssword");
            userService.save(user);

        };

    }

}
