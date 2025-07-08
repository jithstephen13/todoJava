package com.todo.todo.service.impl;

import com.todo.todo.contract.TodoRequest;
import com.todo.todo.contract.TodoResponce;
import com.todo.todo.model.TodoItem;
import com.todo.todo.model.User;
import com.todo.todo.repository.TodoRepository;
import com.todo.todo.repository.UserRepositery;
import com.todo.todo.service.TodoService;
import com.todo.todo.util.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoServiceImplementation implements TodoService {
    private final TodoRepository todoRepository;
    private  final UserRepositery userRepositery;
    private  final ModelMapper modelMapper;

    public TodoServiceImplementation(TodoRepository todoRepository, UserRepositery userRepositery, ModelMapper modelMapper) {
        this.todoRepository = todoRepository;
        this.userRepositery= userRepositery;
        this.modelMapper= modelMapper;
    }

    @Override
    public TodoResponce createTodo(TodoRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // Find the user by username
        User user = userRepositery.findByUsername(username);
        // Create Todo entity
        TodoItem todo = new TodoItem();
        todo.setTitle(request.getTitle());
        todo.setBody(request.getBody());
        todo.setStatus(request.getStatus());
        todo.setCreated_at(request.getCreated_at());
        todo.setUser(user); // set the User (foreign key)
        // Save the todo
        TodoItem savedTodo = todoRepository.save(todo);
        // Create and return response
        TodoResponce response = new TodoResponce();
        response.setId(savedTodo.getId());
        response.setTitle(savedTodo.getTitle());
        response.setStatus(savedTodo.getStatus());
        response.setCreated_at(savedTodo.getCreated_at());

        return response;
    }

    @Override
    public List<TodoResponce> searchAll() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // Find the user by username
        User user = userRepositery.findByUsername(username);
        List<TodoItem> responc=todoRepository.findByUser_id(user.getId());

        return responc.stream()
                .map(x->modelMapper.map(x,TodoResponce.class))
                .collect(Collectors.toList());
    }

    @Override
    public  List<TodoResponce> searchById(Integer request){
        Optional<TodoItem> responc=todoRepository.findById(request);
        return responc.stream()
                .map(x->modelMapper.map(x,TodoResponce.class))
                .collect(Collectors.toList());
    }

    @Override
    public  TodoResponce updateTodoById(TodoRequest request){
        Optional<TodoItem> responc = todoRepository.findById(request.getId());

        if (responc.isEmpty()) {
            throw new RuntimeException("Todo with ID " + request.getId() + " not found.");
        }

        TodoItem existing = responc.get();
        existing.setTitle(request.getTitle());
        existing.setBody(request.getBody());
        existing.setStatus(request.getStatus());
        existing.setCreated_at(request.getCreated_at());

        TodoItem updatedTodo = todoRepository.save(existing);

        // Map to response DTO
        TodoResponce response = new TodoResponce();
        response.setId(updatedTodo.getId());
        response.setTitle(updatedTodo.getTitle());
        response.setBody(updatedTodo.getBody());
        response.setStatus(updatedTodo.getStatus());
        response.setCreated_at(updatedTodo.getCreated_at());

        return response;

    }

    @Override
    public List<TodoResponce> deleteById(Integer request) {
        if (!todoRepository.existsById(request)) {
            throw new RuntimeException("Todo with ID " + request + " not found.");
        }
        todoRepository.deleteById(request);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepositery.findByUsername(username);

        List<TodoItem> todos = todoRepository.findByUser_id(user.getId());

        return todos.stream()
                .map(todo -> modelMapper.map(todo, TodoResponce.class))
                .collect(Collectors.toList());

    };




}
