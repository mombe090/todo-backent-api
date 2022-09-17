package com.mombesoft.tutorials.todobackendapi.dto;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoDto {
    @NotNull
    private String title;
    private boolean status;
}
