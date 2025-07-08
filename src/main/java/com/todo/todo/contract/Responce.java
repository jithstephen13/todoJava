package com.todo.todo.contract;

public class Responce <T>{

    private T payload;
    private String message;

    public Responce() {
    }

    public Responce(T payload, String message) {
        this.payload = payload;
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
