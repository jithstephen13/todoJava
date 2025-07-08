package com.todo.todo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="todo_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username ;
    private  String role;
    private Date created_at;
    private String password ;

    public User() {
    }

    public User(Integer id, String username, String role, Date created_at, String password) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.created_at = created_at;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
