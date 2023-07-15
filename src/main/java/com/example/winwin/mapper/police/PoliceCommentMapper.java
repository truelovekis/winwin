package com.example.winwin.mapper.police;

import com.example.winwin.dto.police.PoliceBoardDto;
import com.example.winwin.dto.police.PoliceCommentDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PoliceCommentMapper {
    //    커뮤니티 댓글 신고하기
    void commentReportInsert(PoliceCommentDto policeCommentDto);
    // qna 댓글 신고하기
    void qnaCommentReportInsert(PoliceCommentDto policeCommentDto);
}
