package com.example.winwin.mapper.file;

import com.example.winwin.dto.user.UserPfpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageFile {
    public void insertProfile(UserPfpDto userPfpDto);
    public UserPfpDto selectProfile(Long userNumber);
    public void updateProfile(UserPfpDto userPfpDto);
    public void deleteProfile(Long userNumber);
}
