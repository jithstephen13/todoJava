package com.todo.todo.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private  String title;
    private  String body;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private String status;
    private LocalDate createdAt;

    public TodoItem() {
    }

    public TodoItem(Integer id, String title, String body, User user, String status, LocalDate createdAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }



}
