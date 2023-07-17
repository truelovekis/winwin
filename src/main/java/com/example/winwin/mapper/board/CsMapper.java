package com.example.winwin.mapper.board;

import com.example.winwin.dto.board.CsDto;
import com.example.winwin.vo.board.CommunityProfileVo;
import com.example.winwin.vo.board.CsProfileVo;
import com.example.winwin.vo.board.CsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CsMapper {
//    추가
    public void insert (CsDto csDto);
//    삭제
    public void delete(Long csNumber);
//    수정
    public void update(CsDto csDto);
//    조회
    public CsVo select(Long csNumber);
//    전체조회
    public List<CsVo> selectAll();
//    프로필 조회
    public List<CsProfileVo> selectUserProfile(Long userNumber);
//    페이지 무한스크롤
    List<CsVo> selectScroll(CsVo csVo);
//    메인페이지 갯수 구하기
    int selectTotal();

    public CsProfileVo userLogin(Long userNumber);
}
