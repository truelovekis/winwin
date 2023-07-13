package com.example.winwin.mapper.board;

import com.example.winwin.dto.board.QnaDto;
import com.example.winwin.dto.board.QsBridgeDto;
import com.example.winwin.vo.board.CommunityProfileVo;
import com.example.winwin.vo.board.QnaProfileVo;
import com.example.winwin.vo.board.QnaVo;
import com.example.winwin.vo.board.QsBridgeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaMapper {
    //추가
    public void insertQna(QnaDto qnaDto);
    public void insertQs(QsBridgeDto QsBridgeDto);

    //리스트 조회
    public List<QnaVo> selectQna();
//    카테고리 조회
//    public List<QnaVo> selectSub(Long qnaNumber);

    // 조회
    public QnaVo selectQnaByQnaNumber(Long qnaNumber);

    // 삭제
    public void deleteQna(Long qnaNumber);
    public void deleteQs(Long qnaNumber);

    // 수정
    public void updateQna(QnaVo qnaVo);
    // 태그 수정
    public void updateQs(QsBridgeDto qsBridgeDto);

    // 조회수
    public int upQna(Long qnaNumber);

   // 댓글 수
    public int qnaCommentCnt(Long qnaNumber);

    // 프로필
    public List<QnaProfileVo> selectUserProfile(Long userNumber);
}