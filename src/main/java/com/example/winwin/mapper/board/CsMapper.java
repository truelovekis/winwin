package com.example.winwin.mapper.board;

import com.example.winwin.dto.board.CsDto;
import com.example.winwin.vo.CsVo;
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
}
