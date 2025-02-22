package com.project.bookmyshow.bookmyshow.controllers;

import com.project.bookmyshow.bookmyshow.dtos.ResponseStatus;
import com.project.bookmyshow.bookmyshow.dtos.UserSignInRequestDto;
import com.project.bookmyshow.bookmyshow.dtos.UserSignUpRequestDto;
import com.project.bookmyshow.bookmyshow.dtos.UserSignUpResponseDto;
import com.project.bookmyshow.bookmyshow.models.Users;
import com.project.bookmyshow.bookmyshow.services.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/signup")
    public UserSignUpResponseDto signUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto){
        Users users = userService.signUp(userSignUpRequestDto.getUsername(), userSignUpRequestDto.getEmail(), userSignUpRequestDto.getPassword());
        UserSignUpResponseDto userSignUpResponseDto = new UserSignUpResponseDto();
        userSignUpResponseDto.setUsername(users.getUsername());
        userSignUpResponseDto.setEmail(users.getEmail());
        userSignUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return userSignUpResponseDto;
    }

    @RequestMapping("/signin")
    public ResponseStatus signIn(@RequestBody UserSignInRequestDto userSignInRequestDto){
        return userService.login(userSignInRequestDto.getEmail(), userSignInRequestDto.getPassword());
    }
}
