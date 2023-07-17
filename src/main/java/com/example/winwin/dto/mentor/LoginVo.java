package com.example.winwin.dto.mentor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class LoginVo {
    private Long userNumber;
    private Long mentorNumber;
    private String userId;
    private String userPassword;
    private String mentorStatus;
    private String userPosition;
}
