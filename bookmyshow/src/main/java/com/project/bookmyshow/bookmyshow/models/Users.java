package com.project.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Users extends BaseModel {
    private String username;
    private String password;
    private String email;
}
