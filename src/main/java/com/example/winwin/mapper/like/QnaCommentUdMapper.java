package com.example.winwin.mapper.like;

import com.example.winwin.vo.board.QnaCommentUdVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QnaCommentUdMapper {
    public Long qnaUdFind(QnaCommentUdVo qnaCommentUdVo);
    public void qnaGoodInsert(QnaCommentUdVo qnaCommentUdVo);
    public void qnaGoodCancle(QnaCommentUdVo qnaCommentUdVo);
    public void qnaHateInsert(QnaCommentUdVo qnaCommentUdVo);
    public void qnaHateCancle(QnaCommentUdVo qnaCommentUdVo);
    public int udCnt(QnaCommentUdVo qnaCommentUdVo);
}
