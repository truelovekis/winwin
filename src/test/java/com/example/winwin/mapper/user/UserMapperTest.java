package com.example.winwin.mapper.user;

import com.example.winwin.dto.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;




@SpringBootTest
@Slf4j
@Transactional
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    private UserDto userDto;

    @BeforeEach
    void setUp() {
        userDto = new UserDto();

        userDto.setUserName("소이");
        userDto.setUserId("aaa");
        userDto.setUserPassword("1234");
        userDto.setUserEmail("aaa@naver.com");
        userDto.setUserRrnumber("001109");
        userDto.setUserBelong("분당고등학교");
        userDto.setUserGender("1");
        userDto.setUserIdentity("1");
        userDto.setUserNickname("숑");
        userDto.setUserStatus("1");
        userDto.setUserGrade(1);
        userDto.setUserWing(5L);
        userDto.setUserPhoneNumber("01020626339");
    }

    @Test
    void join() {
        userMapper.join(userDto);
    }

    @Test
    void login() {
        userMapper.join(userDto);

        Long userNumber = userMapper.login(userDto.getUserId(), userDto.getUserPassword());

        assertThat(userDto.getUserNumber()).isEqualTo(userNumber);
    }

    @Test
    void findUserInfo() {
        userMapper.join(userDto);

        UserDto userInfo = userMapper.findUserInfo(userDto.getUserNumber());

        assertThat(userDto.getUserName()).isEqualTo(userInfo.getUserName());
    }

    @Test
    void testCheckId() {

        int check = userMapper.checkId("aaa");

        assertThat(check).isEqualTo(0);
    }

    @Test
    void checkNickname() {
//        userMapper.join(userDto);

        int check = userMapper.checkNickname("숑");

        assertThat(check).isEqualTo(0);
    }
}

