package com.todo.todo.service.impl;

import com.todo.todo.contract.LoginRequest;
import com.todo.todo.contract.UserRegisrationRequest;
import com.todo.todo.contract.UserRegisrationResponce;
import com.todo.todo.model.User;
import com.todo.todo.repository.UserRepositery;
import com.todo.todo.service.UserServices;
import com.todo.todo.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplimentation implements UserServices {
    private  final UserRepositery userRepositery;


    public UserServiceImplimentation(UserRepositery userRepositery) {
        this.userRepositery = userRepositery;
    }

    @Override
    public String createUser(UserRegisrationRequest request) {
        if (userRepositery.existsByUsername(request.getUsername())) {
            return "Username already exists";
        }
       User user= new User();
       user.setPassword(request.getPassword());
       user.setPassword(request.getPassword());
       user.setUsername(request.getUsername());
       user.setRole(request.getRole());
       user.setCreated_at(request.getCreated_at());
       userRepositery.save(user);

        JwtUtil jwtUtil= new JwtUtil();
        return jwtUtil.generateToken(request.getUsername());
    }

    @Override
    public String loginUser(LoginRequest request) {
        if(userRepositery.existsByUsername(request.getUsername()) ){
            User user=userRepositery.findByUsername(request.getUsername());
            JwtUtil jwtUtil= new JwtUtil();
            return jwtUtil.generateToken(user.getUsername());
        }
        return "Something went wrong please try againg after some time ";

    }
}
