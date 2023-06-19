package com.example.winwin.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class GradeDto {
    private int gradeNumber;
    private String gradeName;
}
