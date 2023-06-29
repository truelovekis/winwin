package com.example.winwin.service.user;

import com.example.winwin.dto.user.UserDto;
import com.example.winwin.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    private UserDto userDto;

    @BeforeEach
    void setUp(){
        userDto = new UserDto();

        userDto.setUserId("aaa");
        userDto.setUserPassword("1234");


    }

    @DisplayName("회원가입 확인")
    @Test
    void userRegister() {
        doNothing().when(userMapper).join(any(UserDto.class));

        userService.userRegister(userDto);

        verify(userMapper, times(1)).join(userDto);
    }

    @DisplayName("로그인 확인")
    @Test
    void findUserNumber() {
        doReturn(1L).when(userMapper).login(any(String.class), any(String.class));

        Long userNumber = userService.findUserNumber("aaa", "1234");

        assertThat(userNumber).isEqualTo(1L);
    }

    @DisplayName("회원 일부 정보 가져오기")
    @Test
    void findUserInfo() {
        doReturn(userDto).when(userMapper).findUserInfo(any(Long.class));

        UserDto user = userService.findUserInfo(1L);

        assertThat(userDto.getUserName()).isEqualTo(user.getUserName());
    }

    @Test
    void checkId() {
        doReturn(0).when(userMapper).checkId(any(String.class));

        int checkNum = userService.checkId("aaa");

        assertThat(checkNum).isEqualTo(0);
    }
}