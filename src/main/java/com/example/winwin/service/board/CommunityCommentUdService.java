package com.example.winwin.service.board;

import com.example.winwin.mapper.like.CommunityCommentUdMapper;
import com.example.winwin.vo.board.CommunityCommentUdVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommunityCommentUdService {
    private final CommunityCommentUdMapper communityCommentUdMapper;

    public Long udFind(CommunityCommentUdVo communityCommentUdVo){
        if (communityCommentUdVo == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        return communityCommentUdMapper.udFind(communityCommentUdVo);
    }

    public void goodInsert(CommunityCommentUdVo communityCommentUdVo){
        System.out.println("커뮤니티서비스 연결성공!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+communityCommentUdVo);
        if (communityCommentUdVo == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        communityCommentUdMapper.goodInsert(communityCommentUdVo);
    }

    public void goodCancle(CommunityCommentUdVo communityCommentUdVo){
        if (communityCommentUdVo == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        communityCommentUdMapper.goodCancle(communityCommentUdVo);
    }

    public void hateInsert(CommunityCommentUdVo communityCommentUdVo){
        System.out.println("커뮤니티서비스 연결성공!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+communityCommentUdVo);
        if (communityCommentUdVo == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        communityCommentUdMapper.hateInsert(communityCommentUdVo);
    }

    public void hateCancle(CommunityCommentUdVo communityCommentUdVo){
        if (communityCommentUdVo == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        communityCommentUdMapper.hateCancle(communityCommentUdVo);
    }


    public int udCnt(CommunityCommentUdVo communityCommentUdVo){
        if (communityCommentUdVo == null) {
            throw new IllegalArgumentException("좋아요 게시글번호, 회원번호 누락");
        }
        return communityCommentUdMapper.udCnt(communityCommentUdVo);
    }



}
