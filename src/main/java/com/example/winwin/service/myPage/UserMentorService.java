package com.example.winwin.service.myPage;

import com.example.winwin.dto.mentor.CareerVo;
import com.example.winwin.dto.mentor.MentorVo;
import com.example.winwin.dto.mentor.SkillVo;
import com.example.winwin.dto.user.UserDto;
import com.example.winwin.mapper.myPage.UserMentorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserMentorService {
    private final UserMentorMapper userMentorMapper;
//    등록된 멘토 프로필
    public List<MentorVo> findMentor(Long userNumber){
        List<MentorVo> list = userMentorMapper.userMentor(userNumber);
        for (int i = 0 ; i<list.size(); i++){
            MentorVo mentorVo = list.get(i);

            Long mentorNumber = mentorVo.getMentorNumber();
            mentorVo.setCareer(userMentorMapper.userMentorCareer(mentorNumber));
            mentorVo.setSkill(userMentorMapper.userMentorSkill(mentorNumber));
        }
        return list;
    }

//    관심멘토
    public List<MentorVo> likeMentor(Long userNumber){
        List<MentorVo> list2 = userMentorMapper.likeMentor(userNumber);
        for (int i=0; i<list2.size(); i++){
            MentorVo mentorVo = list2.get(i);

            Long mentorNumber = mentorVo.getMentorNumber();
            mentorVo.setCareer(userMentorMapper.userMentorCareer(mentorNumber));
            mentorVo.setSkill(userMentorMapper.userMentorSkill(mentorNumber));
        }
        return list2;
    }

    //    멘토 경력 리스트(멘토 프로필 리스트)
    public List<CareerVo> findCareerList(Long mentorNumber){
        List<CareerVo> career = userMentorMapper.userMentorCareer(mentorNumber);


        for (int i=0; i<career.size(); i++){
            career.get(i).getMentorNumber();
            career.get(i).getCareerCompany();
            career.get(i).getCareerTitle();
            career.get(i).getCareerStartDate();
            career.get(i).getCareerEndDate();
            career.get(i).getCareerAnnual();
        }
        return career;
    }

    //    멘토 스킬 리스트(멘토 프로필 리스트)
    public List<SkillVo> findSkill(Long mentorNumber){
        List<SkillVo> skill = userMentorMapper.userMentorSkill(mentorNumber);

        for (int i=0; i<skill.size() ; i++){
            skill.get(i).getMentorNumber();
            skill.get(i).getSkillName();
        }

        return skill;
    }

//    멘티 리스트
    public List<MentorVo> findMentee(Long mentorNumber){

        return userMentorMapper.mentorMentee(mentorNumber);
    }

    //    멘티 수락하기
    public void okMentee(MentorVo mentorVo){
        userMentorMapper.okMentee(mentorVo);
    }

//    멘티 거절하기
    public void noMentee(MentorVo mentorVo){
        userMentorMapper.noMentee(mentorVo);
    }

//    로그인한 유저의 포지션
    public String findLogin(Long userNumber){

        return userMentorMapper.loginUser(userNumber);
    }

}
