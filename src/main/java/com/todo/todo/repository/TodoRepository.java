package com.todo.todo.repository;

import com.todo.todo.contract.TodoResponce;
import com.todo.todo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoItem, Integer> {

    List<TodoItem> findByUser_id(Integer userId);

}
