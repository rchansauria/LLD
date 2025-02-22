package com.project.bookmyshow.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpResponseDto {
    private String username;
    private String email;
    private ResponseStatus responseStatus;
}
