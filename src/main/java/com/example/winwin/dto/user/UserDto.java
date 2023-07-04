package com.example.winwin.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Component
@Data
@NoArgsConstructor
public class UserDto {
    private Long userNumber;
    private String userName;
    private String userId;
    private String userPassword;
    private String userEmail;
    private String userRrnumber;
    private String userGender;
    private String userBelong;
    private String userIdentity;
    private String userNickname;
    private String userStatus;
    private Long userWing;
    private int userGrade;
    private String userPhoneNumber;
    private int userVerification;
    private String userPosition;
}
