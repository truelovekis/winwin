package com.example.winwin.mapper.myPage;

import com.example.winwin.vo.myPage.ActiveBoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
    public List<ActiveBoardVo> selectActiveBoardList(Long userNumber);
}
