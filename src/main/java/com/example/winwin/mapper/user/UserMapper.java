package com.example.winwin.mapper.user;

import com.example.winwin.dto.mentor.CategoryVo;
import com.example.winwin.dto.user.MentorDto;
import com.example.winwin.dto.user.UserPfpDto;
import com.example.winwin.vo.user.CategoryBridgeVo;
import com.example.winwin.dto.user.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    // 관심분야 카테고리
    public List<CategoryVo> categoryH();
    public List<CategoryVo> categoryJ();
    public List<CategoryVo> subCategory(String mainCode);
    
    // 회원이 어떤 카테고리를 선택했는지
    public void categoryBridge(CategoryBridgeVo categoryBridgeVo);

    // 멘토로 가입 시
    public void joinMentor(MentorDto mentorDto);

    // 회원 가입 시 프로필에 회원 번호 올리기
    public void joinPfp(UserPfpDto userPfpDto);

    // 인증 태그 카테고리
    public List<CategoryVo> certificationH();
    public List<CategoryVo> certificationJ();
    public List<CategoryVo> certificationSub(String mainCode);
}

