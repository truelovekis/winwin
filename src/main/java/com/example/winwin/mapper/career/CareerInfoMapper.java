package com.example.winwin.mapper.career;

import com.example.winwin.dto.careerInfo.CareerInfoDto;
import com.example.winwin.dto.mentor.CareerInfoVo;
import com.example.winwin.dto.mentor.CategoryVo;
import com.example.winwin.vo.infinityScroll.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CareerInfoMapper {

//    진로정보 글 등록하기
    void careerInfoInsert(CareerInfoDto careerInfoDto);

//    멘토번호 찾기
    Long selectMentorNumber(Long userNumber);

//    유저 인증태그 찾기
    List<CategoryVo> selectUserTag(Long userNumber);

//    멘토 인증태그 찾기
    CareerInfoVo selectMentorTag(Long userNumber);

//    진로정보 글 번호로 조회하기
    CareerInfoVo careerInfoSelectNumber(Long careerInfoNumber);

//    진로정보 글 전체 좋아요순 및 카테고리 별 조회하기
    List<CareerInfoVo> selectCareerInfoList(@Param("tagList") List<Integer> tagList, @Param("criteria") Criteria criteria);

//    진로정보 메인페이지 갯수구하기
    int selectCareerTotal();

//    진로정보 글 상세보기 진입 시 조회 수 증가
    void careerInfoReadCnt(Long careerInfoNumber);

//    진로정보 글 번호로 수정하기
    void careerInfoUpdate(CareerInfoDto careerInfoDto);

//    진로정보 글 번호로 삭제하기
    void careerInfoDelete(Long careerInfoNumber);
}
