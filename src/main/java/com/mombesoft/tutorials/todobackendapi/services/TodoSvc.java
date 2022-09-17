package com.mombesoft.tutorials.todobackendapi.services;

import com.mombesoft.tutorials.todobackendapi.collections.TodoCollection;
import com.mombesoft.tutorials.todobackendapi.dto.TodoDto;

import java.util.List;

public interface TodoSvc {
    List<TodoCollection> getAllTodos();
    TodoCollection getTodo(String id);
    TodoCollection createTodo(TodoDto todo);
    TodoCollection updateTodo(String id, TodoDto todo);
    boolean deleteTodo(String id);
    void deleteAllTodos();
}
