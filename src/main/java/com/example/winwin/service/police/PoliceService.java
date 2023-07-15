package com.example.winwin.service.police;

import com.example.winwin.dto.police.PoliceBoardDto;
import com.example.winwin.dto.police.PoliceCommentDto;
import com.example.winwin.mapper.police.PoliceBoardMapper;
import com.example.winwin.mapper.police.PoliceCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PoliceService {

    private final PoliceBoardMapper policeBoardMapper;
    private final PoliceCommentMapper policeCommentMapper;

//    나눔 글 신고하기
    public void policeBoardRegister(PoliceBoardDto policeBoardDto){
        if (policeBoardDto == null){
            throw new IllegalArgumentException("게시글 번호가 잘못되었습니다.");
        }

        policeBoardMapper.reportInsert(policeBoardDto);
    }

//    커뮤니티 댓글 신고하기
    public void policeCommentRegister(PoliceCommentDto policeCommentDto){
        if (policeCommentDto == null){
            throw new IllegalArgumentException("게시글 번호가 잘못되었습니다.");
        }

        policeCommentMapper.commentReportInsert(policeCommentDto);
    }

    //    qna 댓글 신고하기
    public void policeQnaCommentRegister(PoliceCommentDto policeCommentDto){
        if (policeCommentDto == null){
            throw new IllegalArgumentException("게시글 번호가 잘못되었습니다.");
        }

        policeCommentMapper.qnaCommentReportInsert(policeCommentDto);
    }




//    신고항목 게시글 번호로 조회하기
    @Transactional(readOnly = true)
    public PoliceBoardDto findBoard(Long boardNumber){
        if (boardNumber == null){
            throw new IllegalArgumentException("게시글 번호가 일치하지 않습니다.");
        }

        return Optional.ofNullable(policeBoardMapper.shareReportSelect(boardNumber))
                .orElseThrow(()->{
                    throw new IllegalArgumentException("존재하지 않는 게시글 입니다.");
                });
    }

//    게시글 삭제 시 신고테이블에서 삭제하기
    public void policeBoardRemove(Long boardNumber){
        if (boardNumber == null){
            throw new IllegalArgumentException("게시글 번호가 일치하지 않습니다.");
        }

        policeBoardMapper.shareReportDelete(boardNumber);
    }

}
