package com.example.winwin.mapper.user;

import com.example.winwin.dto.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    private UserDto userDto;

    @BeforeEach
    void setUp(){
        userDto = new UserDto();

        userDto.setUserName("박웅이");
        userDto.setUserId("eee");
        userDto.setUserPassword("1234");
        userDto.setUserEmail("eee@gmail.com");
        userDto.setUserRrnumber("940406");
        userDto.setUserGender(1);
        userDto.setUserBelong("배달의 민족");
        userDto.setUserIdentity("W");
        userDto.setUserNickname("웅이");
        userDto.setUserGrade(5);
        userDto.setUserWing(300L);
    }

    @Test
    @DisplayName("회원가입 및 로그인 테스트")
    void insert() {
        userMapper.insert(userDto);

        userMapper.selectUserNumber("eee", "1234");

        assertThat(userMapper.selectUserNumber("eee","1234"))
                .isEqualTo(userDto.getUserNumber());
    }

}