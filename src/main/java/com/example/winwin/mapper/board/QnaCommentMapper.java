package com.example.winwin.mapper.board;

import com.example.winwin.dto.board.QnaCommentDto;
import com.example.winwin.vo.board.QnaCommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaCommentMapper {
    public void insertQnaComment(QnaCommentDto qnaCommentDto);
    public List<QnaCommentVo> selectQnaCommentList(Long qnaNumber);
    public QnaCommentVo selectQna(Long commentNumber);
    public void updateQna(QnaCommentDto qnaCommentDto);
    public void delete(Long commentNumber);
    public void deleteQna(Long qnaNumber);
    List<QnaCommentVo> findQnaCommentUdList(QnaCommentVo qnaCommentVo);
}



