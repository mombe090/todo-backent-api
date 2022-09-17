package com.mombesoft.tutorials.todobackendapi.utils;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class ResponseHandlerTest {

    ResponseHandler responseHandler;

    @BeforeEach
    void setup() {
        responseHandler = ResponseHandler.builder()
                .data(null)
                .statusCode(HttpStatus.NO_CONTENT)
                .message(List.of())
                .build();
    }

    @Test
    void responseGenerator() {
        assertEquals(204, responseHandler.responseGenerator().getStatusCode().value());
    }

    @Test
    void getNotFoundEntity() {
    }

    @Test
    void builder() {
    }
}
