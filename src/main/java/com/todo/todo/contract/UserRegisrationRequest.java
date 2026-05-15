package com.todo.todo.contract;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.util.Date;


public class UserRegisrationRequest {
   @Null private Integer id;
   @NotNull private String username ;
   @NotNull private  String role;
   @NotNull private Date created_at;
   @NotNull private String password ;

    public UserRegisrationRequest() {
    }

    public UserRegisrationRequest(Integer id, String username, String role, Date created_at, String password) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.created_at = created_at;
        this.password = password;
    }

    public @Null Integer getId() {
        return id;
    }

    public void setId(@Null Integer id) {
        this.id = id;
    }

    public @NotNull String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public @NotNull String getRole() {
        return role;
    }

    public void setRole(@NotNull String role) {
        this.role = role;
    }

    public @NotNull Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(@NotNull Date created_at) {
        this.created_at = created_at;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }
}
