package com.todo.todo.controller;

import com.todo.todo.contract.Responce;
import com.todo.todo.contract.TodoRequest;
import com.todo.todo.contract.TodoResponce;
import com.todo.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController implements SecureSwaggerController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create")
    public ResponseEntity<Responce<TodoResponce>> createTodo(@RequestBody @Valid TodoRequest request){
        TodoResponce resp=todoService.createTodo(request);
        Responce responce=new Responce<>();
        responce.setPayload(resp);
        responce.setMessage("Sucessfully saved");
        return ResponseEntity.status(HttpStatus.CREATED).body(responce) ;
    }

    @GetMapping(value = "/searchAll")
    public ResponseEntity<Responce<List<TodoResponce>>> searchAll(){
        List<TodoResponce> resp=todoService.searchAll();
        Responce responce=new Responce<>();
        responce.setPayload(resp);
        responce.setMessage("Sucessfully saved");
        return ResponseEntity.status(HttpStatus.CREATED).body(responce);
    }

    @GetMapping(value = "seachById")
    public  ResponseEntity<Responce<List<TodoResponce>>> searchById(@RequestParam("id") Integer id){
        List<TodoResponce> resp=todoService.searchById(id);
        Responce responce=new Responce<>();
        responce.setPayload(resp);
        responce.setMessage("Sucessfully fetched");
        return ResponseEntity.status(HttpStatus.CREATED).body(responce);
    }

    @PatchMapping(value = "/update")
    public ResponseEntity<Responce<TodoResponce>> updateById(@RequestBody @Valid TodoRequest request){
        TodoResponce resp=todoService.updateTodoById(request);
        Responce responce=new Responce<>();
        responce.setPayload(resp);
        responce.setMessage("Sucessfully  updated");
        return ResponseEntity.status(HttpStatus.CREATED).body(responce);

    }
    @DeleteMapping(value = "delete")
    public ResponseEntity<Responce<List<TodoResponce>>> deleteById(@RequestParam("id") Integer id){
        List<TodoResponce> resp= todoService.deleteById(id);
        Responce responce=new Responce<>();
        responce.setPayload(resp);
        responce.setMessage("Sucessfully  Deleted");
        return ResponseEntity.status(HttpStatus.CREATED).body(responce);
    };

}
