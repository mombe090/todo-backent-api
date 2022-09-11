package com.mombesoft.tutorials.todobackentapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoDto {
    private String title;
    private boolean status;
}
