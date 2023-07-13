package com.example.winwin.service.myPage;

import com.example.winwin.mapper.myPage.UserDiaryMapper;
import com.example.winwin.vo.myPage.MyPageCriteria;
import com.example.winwin.vo.myPage.DiaryVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DiaryService {
    private final UserDiaryMapper diaryMapper;

    public List<DiaryVo> findList(Long userNumber){
        List<DiaryVo> list = diaryMapper.diaryList(userNumber);
        return list;
    }

    public void register(DiaryVo diaryVo){
        if(diaryVo == null){
            throw new IllegalArgumentException("정보 누락");
        }
        diaryMapper.diaryInsert(diaryVo);
    }

    public void modify(DiaryVo diaryVo){
        if (diaryVo == null) {
            throw new IllegalArgumentException("수정 실패!");
        }
        diaryMapper.diaryUpdate(diaryVo);
    }

    public List<DiaryVo> findListPage(MyPageCriteria myPageCriteria, Long userNumber){
        if (myPageCriteria == null) {
            throw new IllegalArgumentException("페이지 처리에 필요한 정보 누락");

        }
        return diaryMapper.selectListPage(myPageCriteria, userNumber);
    }

    public int findTotal(){

        return diaryMapper.selectTotal();
    }
}
