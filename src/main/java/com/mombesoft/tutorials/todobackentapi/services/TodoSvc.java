package com.mombesoft.tutorials.todobackentapi.services;

import com.mombesoft.tutorials.todobackentapi.collections.TodoCollection;
import com.mombesoft.tutorials.todobackentapi.dto.TodoDto;

import java.util.List;

public interface TodoSvc {
    List<TodoCollection> getAllTodos();
    TodoCollection getTodo(String id);
    TodoCollection createTodo(TodoDto todo);
    TodoCollection updateTodo(String id, TodoDto todo);
    boolean deleteTodo(String id);
    void deleteAllTodos();
}
