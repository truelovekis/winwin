package com.example.winwin.mapper.user;

import com.example.winwin.dto.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    private UserDto userDto;

    @BeforeEach
    void setUp(){
        userDto = new UserDto();

        userDto.setUserId("aaa");
        userDto.setUserPassword("1234");
        userDto.setUserEmail("aaa@naver.com");
        userDto.setUserBelong("분당고등학교");
        userDto.setUserName("소이");
        userDto.setUserNickname("숑");
        userDto.setUserRrnumber("001109");
        userDto.setUserGender("F");
        userDto.setUserIdentity("H");
        userDto.setUserGrade(5);
        userDto.setUserWing(0L);
        userDto.setUserStatus(1);
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

        int check = userMapper.checkId("bbbb");

        assertThat(check).isEqualTo(0);
    }

    @Test
    void checkNickname() {
//        userMapper.join(userDto);

        int check = userMapper.checkNickname("ㅣㅣ");

        assertThat(check).isEqualTo(0);
    }
}