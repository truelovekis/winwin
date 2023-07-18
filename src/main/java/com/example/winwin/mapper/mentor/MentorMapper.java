package com.example.winwin.mapper.mentor;

import com.example.winwin.dto.mentor.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.management.MemoryNotificationInfo;
import java.util.List;

@Mapper
public interface MentorMapper {
//    멘토:멘티 - MentorMapper.xml
//    멘토 리스트 메인 페이지
    public List<MentorVo> mentorList(@Param("userNumber") Long userNumber, @Param("subList") List<Integer> subNumber);

//    멘토가 등록한 경력 리스트
    public List<CareerVo> mentorCareer(Long mentorNumber);

//    멘토가 등록한 스킬 리스트
    public List<SkillVo> mentorSkill(Long mentorNumber);

//    멘토 프로필 등록하기 업데이트
    public void mentorUpdate(MentorVo mentorVo);

//    로그인한 멘토의 프로필
    public MentorVo loginMentor(Long mentorNumber);

//    멘토 프로필 좋아요 추가하기(관심 멘토)
    public void mentorLike(LikeDto likeDto);

//    멘토 프로필 좋아요 삭제하기
    public void likeDelete(LikeDto likeDto);

//    멘토:멘티 신청
    public void addMentor(MentorVo mentorVo);

//    멘토 프로필 사진 불러오기
    public MentorVo mentorpfp(Long mentorNumber);
//    멘토:멘티 - MentorMapper.xml 끝


//    멘토 프로필-MentorProfileMapper.xml
//    멘토 프로필
    public MentorVo mentor(Long mentorNumber);
    public List<MentorVo> mentor2(Long mentorNumber);
    public MentorVo mentor3(Long mentorNumber);
    public MentorVo mentorProfile(Long mentorNumber , Long userNumber);

//    멘토 프로필 등록 - 자기소개
    public void mentorPr(MentorVo mentorVo);
//    멘토 프로필 수정 - 자기소개
    public void mentorPrU(MentorVo mentorVo);

//    멘토 리뷰 평점
    public MentorVo mentorAvg(Long mentorNumber);
//    멘토 리뷰 등록
    public void reviewInsert(ReviewVo reviewVo);
//    멘토 리뷰
    public List<ReviewVo> reviewList(Long mentorNumber, Long userNumber);

//    멘토 스킬
    public List<SkillVo> profileSkill(Long mentorNumber);
//    멘토 스킬 등록
    public void skillInsert(SkillVo skillVo);
//    멘토 스킬 삭제
    public void skillDelete(Long mentorNumber);

//    멘토 경력
    public List<CareerVo> profileCareer(Long mentorNumber);
//    멘토 경력 등록
    public void careerInsert(CareerVo careerVo);

//    멘토가 작성한 진로정보 리스트
    public List<CareerInfoVo> careerList(Long mentorNumber);
    public int careerInfoLike(Long mentorNumber);

    public int mentorPrCount(Long mentorNumber);
    public int mentorCnt(Long mentorNumber);
    public int skillCnt(Long mentorNumber);
//    멘토 프로필-MentorProfileMapper.xml 끝

//    멘토:멘티 프로필 카테고리
    public List<CategoryVo> categoryList();
}
