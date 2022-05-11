package com.kocirfan.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.kocirfan.shared.GenericResponse;
import com.kocirfan.shared.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class UserController {

    // Logger ile loglarımı daha iyi yönetiyorum üstelik dosyaya yazma vb gibi işlemler için kullanabilirim.
    //private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    //dinleme yaparken aynı zamanda versiyon vererek projenin eski/eski-olacak versiyonlarınıda canlı tutmayı sağlıyorum.

    @PostMapping("/api/1.0/users")
    public GenericResponse createUser(@Valid @RequestBody User user){
        userService.save(user);
        return new GenericResponse("user created");
        //log.info(user.toString());
    }

//    @GetMapping("/api/1.0/users")
//    @JsonView(Views.Base.class)
//    List<User> getUsers(){
//        return userService.getUsers();
//    }

    //Database'den veriyi parça parça almak
//    @GetMapping("/api/1.0/users")
//    //@JsonView(Views.Base.class)
//    Page<User> getUsers(Pageable page){
//        return userService.getUsers(page);
//    }

    //Projection ile user ları database'den almak
    @GetMapping("/api/1.0/users")
    Page<UserProjection> getUsers(Pageable page){
        return userService.getUsers(page);
    }


    //    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ApiError handleValidationException(MethodArgumentNotValidException exception){
//        ApiError error = new ApiError(400, "Validation error", "/api/1.0/users");
//        Map<String, String> validationErrors = new HashMap<>();
//        for(FieldError fieldError: exception.getBindingResult().getFieldErrors()){
//            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
//        }
//        error.setValidationErrors(validationErrors);
//        return error;
//    }
}
