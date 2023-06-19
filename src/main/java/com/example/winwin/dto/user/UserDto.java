package com.example.winwin.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserDto {
    private Long userNumber;
    private String userName;
    private String userId;
    private String userPassword;
    private String userEmail;
    private int userRrnumber;
    private int userGender;
    private String userBelong;
    private String userIdentity;
    private String userNickName;
    private int userStatus;
    private Long userWing;
    private int userGrade;
}
