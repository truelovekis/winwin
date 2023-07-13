package com.example.winwin.mapper.like;

import com.example.winwin.dto.board.QnaGoodDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QnaGoodMapper {
    public Long findQnaLike(QnaGoodDto qnaGoodDto);
    public void qnaLikeUp(QnaGoodDto qnaGoodDto);
    public void qnaLikeDown(QnaGoodDto qnaGoodDto);
    public int likeQnaCnt(QnaGoodDto qnaGoodDto);
}
