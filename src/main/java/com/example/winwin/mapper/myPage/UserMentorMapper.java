package com.example.winwin.mapper.myPage;

import com.example.winwin.dto.mentor.CareerVo;
import com.example.winwin.dto.mentor.MentorVo;
import com.example.winwin.dto.mentor.SkillVo;
import com.example.winwin.dto.user.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Mapper
public interface UserMentorMapper {
//    멘토 프로필 조회
    List<MentorVo> userMentor(Long userNumber);
    List<SkillVo> userMentorSkill(Long mentorNumber);
    List<CareerVo> userMentorCareer(Long mentorNumber);
    List<MentorVo> likeMentor(Long userNumber);
    List<MentorVo> mentorMentee(Long mentorNumber);
    void okMentee(MentorVo mentorVo);
    void noMentee(MentorVo mentorVo);

    String loginUser(Long userNumber);
}
