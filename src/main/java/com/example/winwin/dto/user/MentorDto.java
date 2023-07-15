package com.example.winwin.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MentorDto {
    private Long mentorNumber;
    private String mentorStatus;
    private Long userNumber;
    private int certificationNumber;
}
