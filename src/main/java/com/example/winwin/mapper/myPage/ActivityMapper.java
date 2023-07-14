package com.example.winwin.mapper.myPage;

import com.example.winwin.vo.infinityScroll.Criteria;
import com.example.winwin.vo.myPage.ActiveBoardVo;
import com.example.winwin.vo.myPage.ActiveCommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
    public List<ActiveBoardVo> selectActiveBoardList(Long userNumber, Criteria criteria);
    public List<ActiveCommentVo> selectActiveCommentList(Long userNumber, Criteria criteria);
}
