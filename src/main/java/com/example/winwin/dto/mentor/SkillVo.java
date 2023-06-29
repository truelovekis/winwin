package com.example.winwin.dto.mentor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SkillVo {
    private Long skillNumber;
    private String skillName;
    private Long mentorNumber;
}
