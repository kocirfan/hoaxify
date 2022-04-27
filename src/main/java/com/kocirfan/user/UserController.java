package com.kocirfan.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    // Logger ile loglarımı daha iyi yönetiyorum üstelik dosyaya yazma vb gibi işlemler için kullanabilirim.
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    //dinleme yaparken aynı zamanda versiyon vererek projenin eski/eski-olacak versiyonlarınıda canlı tutmayı sağlıyorum.

    @PostMapping("/api/1.0/users")
    public void createUser(@RequestBody User user){
        log.info(user.toString());
    }
}
