package com.example.winwin.mapper.board;

import com.example.winwin.dto.board.CsCommentDto;
import com.example.winwin.vo.board.CsReplyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CsCommentMapper {
    public void insert(CsCommentDto csCommentDto);
    public List<CsReplyVo> selectList(Long csCommentNumber);
    public CsReplyVo select(Long csNumber);
//    댓글 수정
    public void update(CsCommentDto csCommentDto);
    public void delete(Long commentNumber);
}
