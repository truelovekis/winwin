package com.example.winwin.service.board;

import com.example.winwin.dto.board.StudyDto;
import com.example.winwin.mapper.board.StudyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudyService {

    private final StudyMapper studyMapper;

    public void studyRegister(StudyDto studyDto){
        if(studyDto == null){
            throw new IllegalArgumentException("모임 정보가 누락되었습니다.");
        }
        studyMapper.studyInsert(studyDto);
    }

    public void studyRemove(Long studyNumber){
        if(studyNumber == null){
            throw new IllegalArgumentException("모임 게시물번호가 누락되었습니다.");
        }
        studyMapper.studyDelete(studyNumber);
    }

    public void studyModify(StudyDto studyDto){
        if(studyDto == null){
            throw new IllegalArgumentException("모임 수정 정보가 잘못되었습니다.");
        }
        studyMapper.studyUpdate(studyDto);
    }

    public StudyDto studyFind(Long studyNumber) {
        if (studyNumber == null) {
            throw new IllegalArgumentException("잘못되었습니다.");
        }

        return Optional.ofNullable(studyMapper.studySelect(studyNumber))
                .orElseThrow(()->{
                    throw new IllegalArgumentException("존재하지 않는 글입니다.");
                });

//        return null;
    }

    @Transactional(readOnly = true)
    public List<StudyDto> findMainList(){
        return studyMapper.mainSelect();
    }

}
