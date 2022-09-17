package com.mombesoft.tutorials.todobackendapi.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.mombesoft.tutorials.todobackendapi.collections.TodoCollection;
import com.mombesoft.tutorials.todobackendapi.dto.TodoDto;
import com.mombesoft.tutorials.todobackendapi.services.impl.TodoSvcImpl;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(TodoController.class)
@AutoConfigureDataMongo
class TodoControllerTest {
    @MockBean
    private TodoSvcImpl todoSvc;
    @Autowired
    private MockMvc mockMvc;

    TodoCollection todoCollection;

    @BeforeEach
    void setup() {
        todoCollection   = TodoCollection.builder()
                .id("111")
                .title("Learn K8S")
                .status(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Test
    void todos() throws Exception {
        List<TodoCollection> listOfTestTodos = List.of(
                TodoCollection.builder().title("Learn docker").createdAt(LocalDateTime.now()).build(),
                TodoCollection.builder().title("Learn ansible").createdAt(LocalDateTime.now()).build(),
                TodoCollection.builder().title("Learn gitlab-ci").createdAt(LocalDateTime.now()).build()
        );

        when(todoSvc.getAllTodos())
                .thenReturn(listOfTestTodos);

        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.[0].title", is("Learn docker")))
                .andExpect(jsonPath("$.data.[2].title", is("Learn gitlab-ci")));
    }

    @Test
    void todo() throws Exception {
        when(todoSvc.getTodo("111")).thenReturn(todoCollection);

        mockMvc.perform(get("/todos/{id}", "111"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id", is("111")));
    }

    @Test
    void getTodoWhenIdNotExist() throws Exception {
        when(todoSvc.getTodo(any())).thenReturn(null);

        mockMvc.perform(get("/todos/{id}", "111"))
                .andExpect(status().isNotFound());

    }

    @Test
    void createTodoWhenDtoIsValid() throws Exception {
        when(todoSvc.createTodo(any())).thenReturn(todoCollection);

        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Learn K8S\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    void returnBadRequestWhenDtoIsNotValid() throws Exception {
        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message.[0].title", is("BAD REQUEST")));
    }


    @Test
    void updateTodo() throws Exception {
        String updateTitle = todoCollection.getTitle() + " updated";
        TodoDto todoDto = TodoDto.builder().title(updateTitle).status(false).build();
        todoCollection.setTitle(updateTitle);

        when(todoSvc.updateTodo(any(), any())).thenReturn(todoCollection);


        mockMvc.perform(put("/todos/{id}", "111")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"" + updateTitle + "\"}"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.data.title", is("Learn K8S updated")));
    }

    @Test
    void unUIpdateTodoWhenPayloadIsNotValid() throws Exception {
        String updateTitle = todoCollection.getTitle() + " updated";
        TodoDto todoDto = TodoDto.builder().title(updateTitle).status(false).build();
        todoCollection.setTitle(updateTitle);

        when(todoSvc.updateTodo(any(), any())).thenReturn(todoCollection);


        mockMvc.perform(put("/todos/{id}", "111")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\title\" \"" + updateTitle + "\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deleteTodoWhenIdFound() throws Exception {
        when(todoSvc.deleteTodo(any())).thenReturn(true);

        mockMvc.perform(delete("/todos/{id}", "111")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteTodoWhenIdNotFound() throws Exception {
        when(todoSvc.deleteTodo("111")).thenReturn(false);

        mockMvc.perform(delete("/todos/{id}", "111")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}