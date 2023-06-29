package com.example.winwin.service.police;

import com.example.winwin.dto.police.PoliceBoardDto;
import com.example.winwin.mapper.police.PoliceBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PoliceService {

    private final PoliceBoardMapper policeBoardMapper;

//    나눔 글 신고하기
    public void policeBoardRegister(PoliceBoardDto policeBoardDto){
        if (policeBoardDto == null){
            throw new IllegalArgumentException("게시글 번호가 잘못되었습니다.");
        }

        policeBoardMapper.shareReportInsert(policeBoardDto);
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
