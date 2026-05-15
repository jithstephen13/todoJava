package com.todo.todo.controller;

import com.todo.todo.contract.LoginRequest;
import com.todo.todo.contract.Responce;
import com.todo.todo.contract.UserRegisrationRequest;
import com.todo.todo.service.UserServices;
import com.todo.todo.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private  final JwtUtil jwtUtil;
    private  final UserServices userServices;

    public AuthController(JwtUtil jwtUtil, UserServices userServices) {
        this.jwtUtil = jwtUtil;
        this.userServices = userServices;
    }

    @PostMapping("/register")
    public ResponseEntity<Responce<String>>  Register (@RequestBody @Valid UserRegisrationRequest request){
       String resp=  userServices.createUser(request);
        Responce responce=new Responce<String>();
        responce.setPayload( resp);
        responce.setMessage("sucess");
        return  ResponseEntity.status(HttpStatus.CREATED).body(responce);

    }
    @PostMapping("/login")
    public  ResponseEntity<Responce<String>> login(@RequestBody @Valid LoginRequest request){
        String resp=userServices.loginUser(request);
        Responce responce=new Responce<>();
        responce.setPayload(resp);
        responce.setMessage("Login Sucessfully");
        return  ResponseEntity.status(HttpStatus.CREATED).body(responce);
    }
}
