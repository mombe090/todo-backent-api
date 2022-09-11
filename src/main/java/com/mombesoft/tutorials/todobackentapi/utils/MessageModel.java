package com.mombesoft.tutorials.todobackentapi.utils;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MessageModel {
    private String title;
    private String description;
}
