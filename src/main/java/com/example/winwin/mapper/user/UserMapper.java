package com.example.winwin.mapper.user;

import com.example.winwin.dto.user.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

//    회원가입
    void insert(UserDto userDto);

//    로그인
    Long selectUserNumber(@Param("userId")String userId, @Param("userPassword")String userPassword);
}
