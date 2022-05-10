package com.kocirfan.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.kocirfan.shared.GenericResponse;
import com.kocirfan.error.ApiError;
import com.kocirfan.shared.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/api/1.0/users")
    @JsonView(Views.Base.class)
    List<User> getUsers(){
        return userService.getUsers();
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
