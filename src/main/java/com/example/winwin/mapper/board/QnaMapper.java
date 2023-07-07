package com.example.winwin.mapper.board;

import com.example.winwin.dto.board.CommunityDto;
import com.example.winwin.dto.board.QnaDto;
import com.example.winwin.dto.board.QsBridgeDto;
import com.example.winwin.vo.board.QsBridgeVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QnaMapper {
    //    추가
    public void insertQna(QnaDto qnaDto);
//    public void insertQs(QsBridgeDto QsBridgeDto);
}
