package com.example.winwin.mapper.board;

import com.example.winwin.dto.board.CsCommentDto;
import com.example.winwin.vo.board.CsReplayVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CsCommentMapper {
    public void insert(CsCommentDto csCommentDto);
    public List<CsReplayVo> selectList(Long csCommentNumber);
    public CsReplayVo select(Long csNumber);
    public void update(CsCommentDto csCommentDto);
    public void delete(Long csNumber);
}
