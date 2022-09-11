package com.mombesoft.tutorials.todobackentapi.services.impl;

import com.mombesoft.tutorials.todobackentapi.collections.TodoCollection;
import com.mombesoft.tutorials.todobackentapi.dto.TodoDto;
import com.mombesoft.tutorials.todobackentapi.repository.TodoRepository;
import com.mombesoft.tutorials.todobackentapi.services.TodoSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoSvcImpl implements TodoSvc {
    private final TodoRepository repository;

    @Override
    public List<TodoCollection> getAllTodos() {
        return repository.findAll();
    }

    @Override
    public TodoCollection getTodo(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TodoCollection createTodo(TodoDto todo) {
        return repository.save(
                TodoCollection
                        .builder()
                        .title(todo.getTitle())
                        .build()
        );
    }

    @Override
    public TodoCollection updateTodo(String id, TodoDto todo) {
        TodoCollection todoCollection = repository.findById(id).orElse(null);

        if (todoCollection != null) {
            if (!todo.getTitle().isEmpty() && todo.getTitle() != null) {
                todoCollection.setTitle(todo.getTitle());
            }

            todoCollection.setStatus(todo.isStatus());

           return repository.save(todoCollection);
        }

        return null;
    }

    @Override
    public boolean deleteTodo(String id) {
        TodoCollection todoCollection = repository.findById(id).orElse(null);

        if (todoCollection != null) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public void deleteAllTodos() {
        repository.deleteAll();
    }
}
