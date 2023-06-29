package com.example.winwin.mapper.mentor;

import com.example.winwin.dto.mentor.*;
import org.apache.ibatis.annotations.Mapper;

import java.lang.management.MemoryNotificationInfo;
import java.util.List;

@Mapper
public interface MentorMapper {

//    멘토 프로필 등록 조회
    public MentorVo mentor(Long mentorNumber);
    public List<MentorVo> mentor2(Long mentorNumber);

//    멘토:멘티
//    등록된 멘토 프로필 리스트 조회
    public List<MentorVo> mentorList();

//    멘토가 등록한 경력 리스트
    public List<CareerVo> mentorCareer(Long mentorNumber);
//    멘토가 등록한 스킬 리스트
    public List<SkillVo> mentorSkill(Long mentorNumber);

//    멘토 프로필
//    멘토 프로필 상세 보기
    public MentorVo mentorProfile(Long mentorNumber);
//    멘토 리뷰 평점
    public MentorVo mentorAvg(Long mentorNumber);

//    멘토 스킬
    public List<SkillVo> profileSkill(Long mentorNumber);
    public void skillDelete(Long mentorNumber);

//    멘토 경력
    public List<CareerVo> profileCareer(Long mentorNumber);
//    멘토가 작성한 진로정보 리스트
    public List<CareerInfoVo> careerList(Long mentorNumber);
    public int careerInfoLike(Long mentorNumber);

//  멘토 리뷰
    public List<ReviewVo> reviewList(Long mentorNumber);


//    프로필 등록
//    멘토 프로필 등록
    public void mentorPr(MentorVo mentorVo);
    public void skillInsert(SkillVo skillVo);
    public void careerInsert(CareerVo careerVo);

//    멘토:멘티 프로필 카테고리
    public List<CategoryVo> categoryList();

//    멘토 리뷰 등록
    public void reviewInsert(ReviewVo reviewVo);

//    멘토 프로필 상태 변경
    public void mentorUpdate(MentorVo mentorVo);

//    로그인한 회원의 멘토 프로필
    public MentorVo loginMentor(Long mentorNumber);
}
