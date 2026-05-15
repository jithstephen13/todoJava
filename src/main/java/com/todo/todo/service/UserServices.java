package com.todo.todo.service;

import com.todo.todo.contract.LoginRequest;
import com.todo.todo.contract.UserRegisrationRequest;

public interface UserServices {
     String createUser(UserRegisrationRequest request);
     String loginUser(LoginRequest request);

}
