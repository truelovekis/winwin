package com.example.winwin.service.board;

import com.example.winwin.mapper.like.CommunityGoodMapper;
import com.example.winwin.vo.board.CommunityGoodVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommunityGoodService {
    private final CommunityGoodMapper communityGoodMapper;

    public Long findLike(CommunityGoodVo communityGoodVo){
        if (communityGoodVo == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        return communityGoodMapper.findLike(communityGoodVo);
    }

    public void likeUp(CommunityGoodVo communityGoodVo){
        System.out.println("커뮤니티서비스 연결성공!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+communityGoodVo);
        if (communityGoodVo == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        communityGoodMapper.likeUp(communityGoodVo);
    }

    public void unlike(CommunityGoodVo communityGoodVo){
        if (communityGoodVo == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        communityGoodMapper.unlike(communityGoodVo);
    }

    public int likeCnt(CommunityGoodVo communityGoodVo){
        if (communityGoodVo == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        return communityGoodMapper.likeCnt(communityGoodVo);
    }

}
