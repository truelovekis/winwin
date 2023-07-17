package com.example.winwin.service.mentor;

import com.example.winwin.dto.mentor.*;
import com.example.winwin.mapper.file.MyPageFile;
import com.example.winwin.mapper.mentor.MentorMapper;
import com.example.winwin.vo.myPage.MyPageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MentorService {
    private final MentorMapper mentorMapper;

// 등록된 멘토 프로필 리스트
    @Transactional(readOnly = true)
    public List<MentorVo> findList(Long userNumber, List<Integer> subNumber){
        List<MentorVo> list = mentorMapper.mentorList(userNumber, subNumber);
        for (int i=0; i<list.size(); i++){
            MentorVo mentorVo = list.get(i);

            Long mentorNumber = mentorVo.getMentorNumber();
            mentorVo.setCareer(mentorMapper.mentorCareer(mentorNumber));
            mentorVo.setSkill(mentorMapper.mentorSkill(mentorNumber));
        }
        return list;
    }

//    멘토 경력 리스트(멘토 프로필 리스트)
    public List<CareerVo> findCareerList(Long mentorNumber){
        List<CareerVo> career = mentorMapper.mentorCareer(mentorNumber);


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
        List<SkillVo> skill = mentorMapper.mentorSkill(mentorNumber);

        for (int i=0; i<skill.size() ; i++){
            skill.get(i).getMentorNumber();
            skill.get(i).getSkillName();
        }

        return skill;
    }

//    멘토 프로필 상세 보기
    @Transactional(readOnly = true)
    public MentorVo findProfile(Long mentorNumber, Long userNumber){
        if (mentorNumber == null) {
            throw new IllegalArgumentException("멘토 번호 누락!");
        }
        return mentorMapper.mentorProfile(mentorNumber, userNumber);
    }

//멘토 프로필 상세 보기(리뷰 페이지)
    @Transactional(readOnly = true)
    public MentorVo findReview(Long mentorNumber){
        if (mentorNumber == null) {
            throw new IllegalArgumentException("멘토 번호 누락");
        }
        return mentorMapper.mentorAvg(mentorNumber);
    }

    @Transactional(readOnly = true)
    public List<ReviewVo> findReviewList(Long mentorNumber){
        if (mentorNumber == null) {
            throw new IllegalArgumentException("리뷰 번호 누락!");
        }
        return mentorMapper.reviewList(mentorNumber);
    }

//    멘토 프로필 상세 보기(스킬)
    @Transactional(readOnly = true)
    public List<SkillVo> profileSkill(Long mentorNumber){
        if (mentorNumber == null) {
            throw new IllegalArgumentException("멘토 번호 누락!");
        }
        return mentorMapper.profileSkill(mentorNumber);
    }

//    멘토 프로필 상세보기(경력)
    @Transactional(readOnly = true)
    public List<CareerVo> profileCareer(Long mentorNumber){

        if (mentorNumber == null) {
            throw new IllegalArgumentException("멘토 번호 누락!");
        }
        return mentorMapper.profileCareer(mentorNumber);
    }

//    멘토 프로필 상세보기(게시글 - 진로정보 리스트)
    public List<CareerInfoVo> infoList(Long mentorNumber){
        if (mentorNumber == null) {
            throw new IllegalArgumentException("멘토 번호 누락");
        }
        return mentorMapper.careerList(mentorNumber);
    }

//    멘토 프로필 상세보기(게시글 - 좋아요 수)
    @Transactional(readOnly = true)
    public int careerInfoLike(Long mentorNumber){
        return mentorMapper.careerInfoLike(mentorNumber);
    }

//    멘토:멘티 - 카테고리 리스트
    @Transactional(readOnly = true)
    public List<CategoryVo> findCategoryList(){
        return mentorMapper.categoryList();
    }

//    멘토 프로필 등록하기 - 기본 프로필
    public MentorVo findMentor(Long mentorNumber) {
        if (mentorNumber == null) {
            throw new IllegalArgumentException("멘토 번호 누락!");
        }
        return mentorMapper.mentor(mentorNumber);
    }

    //    멘토 프로필 등록
    public void mentorPrRegister(MentorVo mentorVo){
        if (mentorVo == null) {
            throw new IllegalArgumentException("멘토 번호 누락");
        }
        mentorMapper.mentorPr(mentorVo);
    }

//    멘토 프로필 등록하기 - 스킬
    public void skillRemoveAndRegister(Long mentorNumber , List<String> skillList){
        if (mentorNumber == null) {
            throw new IllegalArgumentException("멘토 번호 누락!");
        }
        mentorMapper.skillDelete(mentorNumber);
//        mentorMapper.skillDelete(6L);
        SkillVo skillVo = new SkillVo();
        skillVo.setMentorNumber(mentorNumber);
//        skillVo.setMentorNumber(6L);
        for (int i=0; i<skillList.size(); i++){
            skillVo.setSkillName(skillList.get(i));
            mentorMapper.skillInsert(skillVo);
        }
    }

//    멘토 프로필 등록하기 - 경력
    public void careerRegister(Long mentorNumber, CareerVo careerVo){
        if (mentorNumber == null) {
            throw new IllegalArgumentException("멘토 번호 누락!");
        }
        mentorMapper.careerInsert(careerVo);
    }

    public List<MentorVo> findMentor2(Long mentorNumber){
        if (mentorNumber == null) {
            throw new IllegalArgumentException("멘토 번호 누락!");
        }
        return mentorMapper.mentor2(mentorNumber);
    }

    public MentorVo findMentor3(Long mentorNumber){
        if (mentorNumber == null) {
            throw new IllegalArgumentException("멘토 번호 누락!");
        }
        return mentorMapper.mentor3(mentorNumber);
    }

//    멘토 리뷰 등록하기
    public void reviewRegister(ReviewVo reviewVo){
        if (reviewVo == null) {
            throw new IllegalArgumentException("리뷰 정보 누락!");
        }
        mentorMapper.reviewInsert(reviewVo);
    }

//    멘토 프로필 상태 변경
    public void modifyMentor(MentorVo mentorVo){
        if (mentorVo == null) {
            throw new IllegalArgumentException("상태? 누락!");
        }
        mentorMapper.mentorUpdate(mentorVo);
    }

//    로그인한 회원의 멘토 프로필
    public MentorVo findLoginMentor(Long mentorNumber){
        if (mentorNumber == null) {
            throw new IllegalArgumentException("멘토 번호 누락!");
        }
        return mentorMapper.loginMentor(mentorNumber);
    }

//    관심 멘토
    public void registerLike(LikeDto likeDto){
        if (likeDto == null) {
            throw new IllegalArgumentException("회원 정보 누락!");
        }
        mentorMapper.mentorLike(likeDto);
    }

//    좋아요 삭제
    public void removeLike(LikeDto likeDto){
        if (likeDto == null) {
            throw new IllegalArgumentException("정보 누락!");
        }
        mentorMapper.likeDelete(likeDto);
    }

//    멘토 신청하기
    public void addMentor(MentorVo mentorVo){
        if (mentorVo == null) {
            throw new IllegalArgumentException("정보 누락!");
        }
        mentorMapper.addMentor(mentorVo);
    }

//    멘토 프로필
    public MentorVo findPfp(Long mentorNumber){

        return mentorMapper.mentorpfp(mentorNumber);
    }

//    멘토 프로필 업데이트
    public void findMentorPrU(MentorVo mentorVo){
        mentorMapper.mentorPrU(mentorVo);
    }

    public int findMentorPrCnt(Long mentorNumber){
        return mentorMapper.mentorPrCount(mentorNumber);
    }

    public int findCnt(Long mentorNumber){
        return mentorMapper.mentorCnt(mentorNumber);
    }

    public int skillCnt(Long mentorNumber){
        return mentorMapper.skillCnt(mentorNumber);
    }

}
