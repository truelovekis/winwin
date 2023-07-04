package com.example.winwin.dto.mentor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class LikeDto {
    private Long mentorNumber;
    private Long userNumber;
}
