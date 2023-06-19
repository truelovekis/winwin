package com.example.winwin.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MentorSkillDto {
    private Long skillNumber;
    private String skillName;
    private Long mentorNumber;
}
