package com.mombesoft.tutorials.todobackendapi.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mombesoft.tutorials.todobackendapi.dto.MessageModel;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseHandler {
    private HttpStatus statusCode;
    private List<MessageModel> message;
    private Object data;

    public ResponseEntity<Object> responseGenerator() {
        Map<String, Object> map = new HashMap<>();

        if (message != null) {
            map.put("message", message);
        }

        if (data != null) {
            map.put("data", data);
        }

        map.put("statusCode", statusCode.value());

        return new ResponseEntity<>(map, statusCode);
    }

    public static ResponseEntity<Object> getNotFoundEntity(String id) {
        return ResponseHandler
                .builder()
                .statusCode(HttpStatus.NOT_FOUND)
                .message(
                        List.of(
                                MessageModel
                                        .builder()
                                        .title("TODO NOT FOUND")
                                        .description( "The todo with " + id + " not exist")
                                        .build()
                        )
                )
                .build()
                .responseGenerator();
    }
}
