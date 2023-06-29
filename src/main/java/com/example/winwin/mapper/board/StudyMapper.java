package com.example.winwin.mapper.board;

import com.example.winwin.dto.board.StudyDto;
import com.example.winwin.vo.board.StudyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyMapper {

    //    추가
    public void studyInsert(StudyDto studyDto);
    //    삭제
    public void studyDelete(Long studyNumber);
    //    수정
    public void studyUpdate(StudyDto studyDto);

    //    프로젝트,모임 메인페이지
    public List<StudyVo> mainSelect(int cateNumber);

    //    글 상세보기
    public StudyDto studySelect(Long studyNumber);

    // 최신순 전체조회
//    public List<StudyDto> studySelectAll();
}