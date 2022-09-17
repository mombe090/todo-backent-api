package com.mombesoft.tutorials.todobackendapi.services.impl;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mombesoft.tutorials.todobackendapi.collections.TodoCollection;
import com.mombesoft.tutorials.todobackendapi.dto.TodoDto;
import com.mombesoft.tutorials.todobackendapi.repository.TodoRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TodoSvcImplTest {
    @MockBean
    private TodoRepository todoRepository;

    @Autowired
    private TodoSvcImpl todoSvc;

    @Test
    void findTodos() {
        when(todoRepository.findAll()).thenReturn(List.of(
                TodoCollection.builder()
                        .title("Test from spring")
                        .status(true)
                        .build()
        ));
        List<TodoCollection> todos = todoSvc.getAllTodos();
        assertThat(todos).isNotEmpty();
        assertThat(todos.get(0).getTitle()).isEqualTo("Test from spring");
        assertTrue(todos.get(0).isStatus());
    }

    @Test
    void findTodo() {
        when(todoRepository.findById("0145548784545454")).thenReturn(Optional.of(
                TodoCollection.builder()
                        .id("0145548784545454")
                        .title("Test from spring")
                        .status(true)
                        .build()
        ));

        assertEquals("0145548784545454", todoSvc.getTodo("0145548784545454").getId());
    }

    @Test
    void addTodo() throws Exception {
        when(todoRepository.save(
                TodoCollection.builder()
                        .title("Add new todo")
                        .build()

        )).thenReturn(TodoCollection.builder()
                .status(false)
                .build()
        );

        assertFalse(todoSvc.createTodo(TodoDto.builder().title("Add new todo").build()).isStatus());
    }

    @Test
    void updateTodo() {
        when(todoRepository.findById("123")).thenReturn(Optional.of(
                TodoCollection.builder()
                        .id("123")
                        .build()
        ));

        when(todoRepository.save(
                TodoCollection.builder()
                        .id("123")
                        .title("update existing todo")
                        .build()

        )).thenReturn(TodoCollection.builder()
                .id("123")
                .title("update existing todo")
                .build()
        );


        assertFalse(todoSvc.updateTodo("123" , TodoDto.builder().title("update existing todo").build()).isStatus());
    }

    @Test
    void deleteTodo() {
        when(todoRepository.findById("532")).thenReturn(Optional.of(
                TodoCollection.builder().build()
        ));

        assertTrue(todoSvc.deleteTodo("532"));
    }
}