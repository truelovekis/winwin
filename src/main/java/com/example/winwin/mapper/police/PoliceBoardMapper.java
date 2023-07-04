package com.example.winwin.mapper.police;

import com.example.winwin.dto.police.PoliceBoardDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PoliceBoardMapper {

//    신고항목 게시글 번호로 조회하기
    PoliceBoardDto shareReportSelect(Long boardNumber);

//    게시글 삭제 시 신고테이블에서 삭제
    void shareReportDelete(Long boardNumber);

//    커뮤니티 게시글 신고하기
    void reportInsert(PoliceBoardDto policeBoardDto);


}
