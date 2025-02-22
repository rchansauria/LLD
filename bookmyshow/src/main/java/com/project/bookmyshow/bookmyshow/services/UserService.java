package com.project.bookmyshow.bookmyshow.services;

import com.project.bookmyshow.bookmyshow.dtos.ResponseStatus;
import com.project.bookmyshow.bookmyshow.models.Users;
import com.project.bookmyshow.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Users signUp(String username, String email, String password){
        Optional<Users> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            //Redirect to logn
        }
        Users user = new Users();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setUsername(username);

        userRepository.save(user);

        return user;
    }

    public ResponseStatus login(String email, String password){
        Optional<Users> optionalUser = userRepository.findByEmail(email);
        if(!optionalUser.isPresent()){
            //Redirect to signup
        }
        if(bCryptPasswordEncoder.matches(password, optionalUser.get().getPassword())){
            return ResponseStatus.SUCCESS;
        }

        return ResponseStatus.FAILURE;
    }
}
