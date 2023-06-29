package com.example.winwin.vo.user;

import com.example.winwin.dto.user.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class UserVo {
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
    private String userPhoneNumber;
    private int userStatus;
    private Long userWing;
    private String gradeName;
}
