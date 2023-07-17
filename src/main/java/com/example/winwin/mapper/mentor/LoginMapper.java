package com.example.winwin.mapper.mentor;

import com.example.winwin.dto.mentor.LoginVo;
import com.example.winwin.dto.mentor.MentorVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    public Long loginMentor(@Param("userId")String userId, @Param("userPassword")String userPassword);
    public MentorVo loginUser(@Param("userId")String userId, @Param("userPassword")String userPassword);
}
