package com.kocirfan.user.vm;

import com.kocirfan.user.User;
import lombok.Data;

@Data
public class UserVM {

    //VM- View Model --- DTO- Data Transfer Object

    private String username;

    private String displayName;

    private String image;

    public UserVM(User user) {
        this.setUsername(user.getUsername());
        this.setDisplayName(user.getDisplayName());
        this.setImage(user.getImage());
    }
}
