package com.example.winwin.service.qna;

import com.example.winwin.dto.board.QnaGoodDto;
import com.example.winwin.mapper.like.QnaGoodMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class QnaGoodService {

    private final QnaGoodMapper qnaGoodMapper;

    public Long findQnaLike(QnaGoodDto qnaGoodDto){
        if (qnaGoodDto == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        return qnaGoodMapper.findQnaLike(qnaGoodDto);
    }

    public void qnaLikeUp(QnaGoodDto qnaGoodDto){
        System.out.println("커뮤니티서비스 연결성공!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+qnaGoodDto);
        if (qnaGoodDto == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        qnaGoodMapper.qnaLikeUp(qnaGoodDto);
    }

    public void qnaLikeDown(QnaGoodDto qnaGoodDto){
        if (qnaGoodDto == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        qnaGoodMapper.qnaLikeDown(qnaGoodDto);
    }

    public int likeQnaCnt(QnaGoodDto qnaGoodDto){
        if (qnaGoodDto == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        return qnaGoodMapper.likeQnaCnt(qnaGoodDto);
    }
}
