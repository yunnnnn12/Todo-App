package com.example.todo.controller;

import com.example.todo.dto.UpdateTodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*") // CORS 허용
@RestController
@RequestMapping("/todos")
public class TodoController{
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.findAll();
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.create(todo.getTitle());
    }

    @PatchMapping("/{id}")
    public Todo updateTodo(
            @PathVariable Long id,
            @RequestBody UpdateTodoDto request
    ) {
        return todoService.update(
                id,
                request.getTitle(),
                request.getCompleted()
        );
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
    }
}
