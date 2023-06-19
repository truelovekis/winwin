package com.example.winwin.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class TodoDto {
    private Long todoNumber;
    private String todoList;
    private Long userNumber;
}
