package com.example.winwin.mapper.myPage;

import com.example.winwin.vo.myPage.MyPageCriteria;
import com.example.winwin.vo.myPage.DiaryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDiaryMapper {
    public void diaryInsert(DiaryVo diaryVo);
    public List<DiaryVo> diaryList(Long userNumber);
    public void diaryUpdate(DiaryVo diaryVo);
    public List<DiaryVo> selectListPage(@Param("criteria") MyPageCriteria myPageCriteria,@Param("userNumber") Long userNumber);
    public int selectTotal();
}
