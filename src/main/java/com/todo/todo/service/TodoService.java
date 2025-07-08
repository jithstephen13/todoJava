package com.todo.todo.service;

import com.todo.todo.contract.TodoRequest;
import com.todo.todo.contract.TodoResponce;

import java.util.List;

public interface TodoService {
    TodoResponce createTodo(TodoRequest request);
    List<TodoResponce> searchAll();
    List<TodoResponce> searchById(Integer request);
    TodoResponce updateTodoById(TodoRequest request);
    List<TodoResponce> deleteById(Integer request);



}
