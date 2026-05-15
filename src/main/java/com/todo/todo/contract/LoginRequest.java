package com.todo.todo.contract;

import jakarta.validation.constraints.NotNull;

import javax.xml.crypto.Data;

public class LoginRequest {
   @NotNull private String username ;
   @NotNull private String password ;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public @NotNull String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }
}
