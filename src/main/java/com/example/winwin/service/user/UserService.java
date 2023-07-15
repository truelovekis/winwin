package com.example.winwin.service.user;

import com.example.winwin.dto.mentor.CategoryVo;
import com.example.winwin.dto.user.MentorDto;
import com.example.winwin.dto.user.UserDto;
import com.example.winwin.dto.user.UserPfpDto;
import com.example.winwin.mapper.user.UserMapper;
import com.example.winwin.vo.user.CategoryBridgeVo;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    private final UserDto userDto;

//    회원 등록
    public void userRegister(UserDto userDto){
        if(userDto == null){ throw new IllegalArgumentException("회원 정보 xxxxxxxxxxxxxx");}
        userMapper.join(userDto);

    }



//    로그인
    public Long findUserNumber(String userId, String userPassword){
        if(userId == null || userPassword == null){throw new IllegalArgumentException("아이디, 패스워드 xxxxxxxxxxxx");}

        return Optional.ofNullable(userMapper.login(userId, userPassword))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하지 않는 회원");});
    }

//    회원 일부 정보 가져오기
    public UserDto findUserInfo(Long userNumber){
        if(userNumber == null){throw new IllegalArgumentException("회원 번호 누락");};

        return Optional.ofNullable(userMapper.findUserInfo(userNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하지 않는 회원");});
    }

//    아이디 중복 검사
    public int checkId(String userId){
        if(userId == null){
            throw new IllegalArgumentException("아이디가 없습니다.");
        }
        return userMapper.checkId(userId);
    }

    //    닉네임 중복 검사
    public int checkNickname(String userNickname){
        if(userNickname == null){
            throw new IllegalArgumentException("닉네임 없음");
        }
        return userMapper.checkNickname(userNickname);
    }

    // 관심분야 카테고리
    public List<CategoryVo> findCategoryJ(){
        List<CategoryVo> categoryJ = userMapper.categoryJ();

        for (int i=0; i<categoryJ.size(); i++){
            categoryJ.get(i).getMainCode();
            categoryJ.get(i).getMainName();
        }

        return categoryJ;
    }

    public List<CategoryVo> findCategoryH(){
        List<CategoryVo> categoryH = userMapper.categoryH();

        for (int i=0; i<categoryH.size(); i++){
            categoryH.get(i).getSubNumber();
            categoryH.get(i).getSubName();
        }

        return categoryH;
    }

    public List<CategoryVo> findSubCategory(String maindCode){
        List<CategoryVo> subCategory = userMapper.subCategory(maindCode);
        return subCategory;
    }

    public void categoryBridge(CategoryBridgeVo categoryBridgeVo){
        if(categoryBridgeVo == null){throw new IllegalArgumentException("존재하지 않는 카테고리 번호");};
        userMapper.categoryBridge(categoryBridgeVo);

    }

    public void joinMentor(MentorDto mentorDto){
        if(mentorDto == null){throw new IllegalArgumentException("존재하지 않는 회원");};
        userMapper.joinMentor(mentorDto);
    }

    public void joinPfp(UserPfpDto userPfpDto){
        userMapper.joinPfp(userPfpDto);
    }

    // 인증 태그 카테고리
    public List<CategoryVo> certificationH(){
        List<CategoryVo> categoryH = userMapper.certificationH();

        for (int i=0; i<categoryH.size(); i++){
            categoryH.get(i).getMainCode();
            categoryH.get(i).getMainName();
        }

        return categoryH;
    }

    public List<CategoryVo> certificationJ(){
        List<CategoryVo> categoryJ = userMapper.certificationJ();

        for(int i=0; i<categoryJ.size(); i++){
            categoryJ.get(i).getSubNumber();
            categoryJ.get(i).getSubName();
        }

        return categoryJ;
    }

    public List<CategoryVo> certificationSub(String mainCode){
        List<CategoryVo> subCategory = userMapper.certificationSub(mainCode);
        System.out.println(subCategory);
        return subCategory;
    }

}
