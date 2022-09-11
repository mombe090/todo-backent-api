package com.mombesoft.tutorials.todobackentapi.controller;

import com.mombesoft.tutorials.todobackentapi.collections.TodoCollection;
import com.mombesoft.tutorials.todobackentapi.dto.TodoDto;
import com.mombesoft.tutorials.todobackentapi.services.impl.TodoSvcImpl;
import com.mombesoft.tutorials.todobackentapi.utils.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.mombesoft.tutorials.todobackentapi.utils.ResponseHandler.getNotFoundEntity;

@RestController
@RequestMapping({"/", "/todos"})
@RequiredArgsConstructor
public class TodoController {
    private final TodoSvcImpl todoSvc;

    @GetMapping()
    public ResponseEntity<Object> todos() {
        return ResponseHandler
                .builder()
                .statusCode(HttpStatus.OK)
                .data(todoSvc.getAllTodos())
                .build()
                .responseGenerator();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> todo(@PathVariable String id) {
        TodoCollection todoCollection = todoSvc.getTodo(id);
        if (todoCollection != null) {
            return ResponseHandler
                    .builder()
                    .statusCode(HttpStatus.OK)
                    .data(todoCollection)
                    .build()
                    .responseGenerator();
        } else  {
            return getNotFoundEntity(id);
        }
    }

    @PostMapping()
    public ResponseEntity<Object> createTodo(@Validated @RequestBody TodoDto todoDto) {
            return ResponseHandler
                    .builder()
                    .statusCode(HttpStatus.ACCEPTED)
                    .data(todoSvc.createTodo(todoDto))
                    .build()
                    .responseGenerator();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateTodo(@Validated @RequestBody TodoDto todoDto, @PathVariable String id) {
        TodoCollection todoCollection = todoSvc.updateTodo(id, todoDto);

        if (todoCollection != null) {
            return ResponseHandler
                    .builder()
                    .statusCode(HttpStatus.ACCEPTED)
                    .data(todoCollection)
                    .build()
                    .responseGenerator();
        } else  {
            return getNotFoundEntity(id);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable String id) {
        if (todoSvc.deleteTodo(id)) {
            return ResponseHandler
                    .builder()
                    .statusCode(HttpStatus.NO_CONTENT)
                    .build()
                    .responseGenerator();
        }

        return getNotFoundEntity(id);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAll() {
        todoSvc.deleteAllTodos();
        return ResponseHandler
                .builder()
                .statusCode(HttpStatus.NO_CONTENT)
                .build()
                .responseGenerator();
    }


}
