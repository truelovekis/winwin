package com.example.winwin.mapper.user;

import com.example.winwin.dto.user.UserDto;
import com.example.winwin.vo.user.UserCategoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    // 회원가입
    public void join(UserDto userDto);

    // 로그인
    public Long login(@Param("userId")String userId, @Param("userPassword")String userPassword);

    // 관심분야 카테고리
//    public UserCategoryVo userCategory();

    // 회원번호로 회원 이름, 윙 갯수 조회
    public UserDto findUserInfo(Long userNumber);

    // 아이디 중복 체크
    public int checkId(String userId);    
    
    // 닉네임 중복 체크
    public int checkNickname(String userNickname);
}
