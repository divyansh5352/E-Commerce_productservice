package com.scaler.productservice.DTO;

import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class userDTO {
    private String name;
    private String email;
    private List<Role> roles;
    private boolean isEmailVerified;

}
