package com.example.winwin.service.board;

import com.example.winwin.dto.board.StudyDto;
import com.example.winwin.mapper.board.StudyMapper;
import com.example.winwin.vo.board.StudyVo;
import com.example.winwin.vo.infinityScroll.Criteria;
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

    /* 글쓰기 */
    public void studyRegister(StudyDto studyDto){
        if(studyDto == null){
            throw new IllegalArgumentException("모임 정보가 누락되었습니다.");
        }
        studyMapper.studyInsert(studyDto);
    }

    /* 글쓰기 삭제*/
    public void studyRemove(Long studyNumber){
        if(studyNumber == null){
            throw new IllegalArgumentException("모임 게시물번호가 누락되었습니다.");
        }
        studyMapper.studyDelete(studyNumber);
    }

    /* 글쓰기 좋아요 삭제*/
    public void studyLikeRemove(Long studyNumber){
        if(studyNumber == null){
            throw new IllegalArgumentException("좋아요 누른 게시글이 없습니다.");
        }
        studyMapper.studyLikeDelete(studyNumber);
    }

    /* 글쓰기 넣기*/
    public void likeRegister(Long userNumber, Long studyNumber){
        if (userNumber == null || studyNumber == null) {
            throw new IllegalArgumentException("좋아요 번호 누락.");
        }
        studyMapper.likeInsert(userNumber, studyNumber);
    }

    /* 좋아요 삭제*/
    public void likeRemove(Long userNumber, Long studyNumber){
        if (userNumber == null || studyNumber == null) {
            throw new IllegalArgumentException("좋아요 번호 누락.");
        }
        studyMapper.likeDelete(userNumber, studyNumber);
    }

    /* 좋아요 조회와 삽입*/
    public void likeProcess(Long userNumber, Long studyNumber){
        if (userNumber == null || studyNumber == null) {
            throw new IllegalArgumentException("좋아요 번호 누락.");
        }
        if(studyMapper.likeSelect(userNumber, studyNumber) == 0){
            studyMapper.likeInsert(userNumber, studyNumber);
        }else{
            studyMapper.likeDelete(userNumber, studyNumber);
        }
    }

    /* 유저번호 게시글번호 연동 */
    public int findLikeCnt(Long userNumber, Long studyNumber){
        if (userNumber == null || studyNumber == null) {
            throw new IllegalArgumentException("좋아요 번호 누락.");
        }
        return studyMapper.likeSelect(userNumber, studyNumber);
    }

    /* 조회수 */
    public void readUpdate(Long studyNumber){
        if ( studyNumber == null){
            throw new IllegalArgumentException("조회수 넘버 못찾음");
        }
        studyMapper.readCount(studyNumber);
    }

    /* 글쓰기 수정*/
    public void studyModify(StudyVo studyVo){
        if(studyVo == null){
            throw new IllegalArgumentException("모임 수정 정보가 잘못되었습니다.");
        }
        studyMapper.studyUpdate(studyVo);
    }

    /* 게시글 찾기*/
    public StudyVo studyFind(Long studyNumber) {
        if (studyNumber == null) {
            throw new IllegalArgumentException("잘못되었습니다.");
        }

        return Optional.ofNullable(studyMapper.studySelect(studyNumber))
                .orElseThrow(()->{
                    throw new IllegalArgumentException("존재하지 않는 글입니다.");
                });

    }


    /* 메인 글 작성 리스트 */
    @Transactional(readOnly = true)
    public List<StudyVo> findMainList(int cateNumber){
        return studyMapper.mainSelect(cateNumber);
    }

    /* 프로젝트 글 작성 리스트 */
    @Transactional(readOnly = true)
    public List<StudyVo> otherProjectList(int cateNumber){
        return studyMapper.otherProject(cateNumber);
    }

    /* 모임 글 작성 리스트 */
    @Transactional(readOnly = true)
    public List<StudyVo> findOtherList(Long cateNumber){
        return studyMapper.selectOtherList(cateNumber);
    }

    /* 무한 스크롤 처리*/
      @Transactional(readOnly = true)
      public List<StudyVo> getRecruitingProjects(int categoryNumber, Criteria criteria) {
          return studyMapper.recruiting(categoryNumber, criteria);
      }


      @Transactional(readOnly = true)
    public int getRecruitingTotal(int categoryNumber){
          return studyMapper.selectRecruitingTotal(categoryNumber);
      }
}
