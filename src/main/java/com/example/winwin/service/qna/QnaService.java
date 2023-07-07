package com.example.winwin.service.qna;

import com.example.winwin.dto.board.CommunityDto;
import com.example.winwin.dto.board.QnaDto;
import com.example.winwin.dto.board.QsBridgeDto;
import com.example.winwin.mapper.board.CommunityMapper;
import com.example.winwin.mapper.board.QnaMapper;
import com.example.winwin.vo.board.QsBridgeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class QnaService {
    private final QnaMapper qnaMapper;

    // 글 등록
    public void registerQna(QnaDto qnaDto){
        if (qnaDto == null) {
            throw new IllegalArgumentException("게시판 정보가 없습니다.");
        }
        qnaMapper.insertQna(qnaDto);
    }

    // 카테고리 넣기
//    public void registerQs(QsBridgeDto qsBridgeDto){
//        if (qsBridgeDto == null) {
//            throw new IllegalArgumentException("카테고리 정보가 없습니다.");
//        }
//        qnaMapper.insertQs(qsBridgeDto);
//    }
}
