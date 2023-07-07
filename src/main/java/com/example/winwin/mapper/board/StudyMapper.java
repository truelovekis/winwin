package com.example.winwin.mapper.board;

import com.example.winwin.dto.board.StudyDto;
import com.example.winwin.vo.board.StudyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyMapper {

    //    추가
    public void studyInsert(StudyDto studyDto);

    //    삭제
    public void studyDelete(Long studyNumber);

    // 라이크 삭제
    public void studyLikeDelete(Long studyNumber);

    // 라이크 추가
    public void likeInsert(@Param("userNumber") Long userNumber,@Param("studyNumber") Long studyNumber);

    // 라이크 유저 게시글 조회 삭제
    public  void likeDelete(@Param("userNumber") Long userNumber, @Param("studyNumber") Long studyNumber);

    //    수정
    public void studyUpdate(StudyVo studyVo);

    //    프로젝트,모임 메인페이지
    public List<StudyVo> mainSelect(int cateNumber);

    //    글 상세보기
    public StudyVo studySelect(Long studyNumber);

    public List<StudyVo> otherProject(int cateNumber);

    /* 좋아요 상호관계 처리*/
    public int likeSelect(@Param("userNumber") Long userNumber, @Param("studyNumber") Long studyNumber);

    /*다른 게시물 리스트*/
    public List<StudyVo> selectOtherList(Long cateNumber);

    /*조회수 처리*/
    public void readCount(Long studyNumber);

}