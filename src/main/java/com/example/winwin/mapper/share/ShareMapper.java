package com.example.winwin.mapper.share;

import com.example.winwin.dto.share.ShareDto;
import com.example.winwin.vo.infinityScroll.Criteria;
import com.example.winwin.vo.share.ShareVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface ShareMapper {

//    나눔 글 등록하기
    void shareInsert(ShareDto shareDto);

//    나눔 글 번호로 조회하기
    ShareVo shareSelectNumber(Long shareNumber);

//    나눔 글 전체 최신순 조회하기
    List<ShareVo> shareSelectAll();

//    나눔 글 상세보기 진입 시 조회 수 증가
    void shareReadCnt(Long shareNumber);

//    나눔 글 번호로 수정하기
    void shareUpdate(ShareDto shareDto);

//    나눔 글 번호로 삭제하기
    void shareDelete(Long shareNumber);

//    나눔 페이지 무한스크롤
    List<ShareVo> selectScroll(Criteria criteria);

//    나눔 메인페이지 갯수 구하기
    int selectTotal();
}
