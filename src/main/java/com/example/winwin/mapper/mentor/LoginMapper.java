package com.example.winwin.mapper.mentor;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    public Long loginMentor(@Param("userId")String userId, @Param("userPassword")String userPassword);
}
