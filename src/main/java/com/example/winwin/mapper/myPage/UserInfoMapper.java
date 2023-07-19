package com.example.winwin.mapper.myPage;

import com.example.winwin.dto.user.UserDto;
import com.example.winwin.vo.user.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper {
//    본인 정보 불러오기
    //    이름, 닉네임, 연락처, 이메일, 등급명
    public UserVo selectUserInfo(Long userNumber);
    //    멘토여부, 현재 직업
    public List<String> selectMentorTag(Long userNumber);
    //    관심 태그
    public List<Map<Integer, String>> selectInterestTag(Long userNumber);
    //    작성한 글수
    public int selectBoardCnt(Long userNumber);
    //    작성한 댓글수
    public int selectCommentCnt(Long userNumber);

//    본인 정보 수정
    public void updateUserInfo(UserDto userDto);
//    관심태그 삭제
    public void deleteInterestTag(Long userNumber);
//    관심태그 추가
    public void insertInterestTag(int subNumber, Long userNumber);
//    멘토 여부
    public int checkMentor(Long userNumber);
//    등급명
    public String selectGradeName(Long userNumber);
//    닉네임
    public String selectUserNickname(Long userNumber);

//    회원 탈퇴
    public void deleteUser(Long userNumber);

}
