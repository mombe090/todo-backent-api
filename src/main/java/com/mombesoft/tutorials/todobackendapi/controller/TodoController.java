package com.mombesoft.tutorials.todobackendapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mombesoft.tutorials.todobackendapi.collections.TodoCollection;
import com.mombesoft.tutorials.todobackendapi.dto.MessageModel;
import com.mombesoft.tutorials.todobackendapi.dto.TodoDto;
import com.mombesoft.tutorials.todobackendapi.services.impl.TodoSvcImpl;
import com.mombesoft.tutorials.todobackendapi.utils.ResponseHandler;

import lombok.RequiredArgsConstructor;

import static com.mombesoft.tutorials.todobackendapi.utils.ResponseHandler.*;

@RestController
@CrossOrigin(origins = {"*"})
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
        if (todoDto == null || todoDto.getTitle() == null) {
            return ResponseHandler
                    .builder()
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .message(List.of(MessageModel.builder().title("BAD REQUEST").description("Title or object can not be null").build()))
                    .build()
                    .responseGenerator();
        }
        return ResponseHandler
                .builder()
                .statusCode(HttpStatus.CREATED)
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
