package com.example.winwin.mapper.like;

import com.example.winwin.vo.board.CommunityGoodVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityGoodMapper {
    public Long findLike(CommunityGoodVo communityGoodVo);
    public void likeUp(CommunityGoodVo communityGoodVo);
    public void unlike(CommunityGoodVo communityGoodVo);
    public int likeCnt(CommunityGoodVo communityGoodVo);

}
