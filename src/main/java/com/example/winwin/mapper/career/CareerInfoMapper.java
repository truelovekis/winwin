package com.example.winwin.mapper.career;

import com.example.winwin.dto.careerInfo.CareerInfoDto;
import com.example.winwin.dto.mentor.CareerInfoVo;
import com.example.winwin.dto.mentor.CategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CareerInfoMapper {

//    진로정보 글 등록하기
    void careerInfoInsert(CareerInfoVo careerInfoVo);

//    멘토번호 찾기
    Long selectMentorNumber(Long userNumber);

//    멘토 인증태그 찾기
    List<CategoryVo> selectMentorTag(Long userNumber);

//    진로정보 글 번호로 조회하기
    CareerInfoDto careerInfoSelectNumber(Long careerInfoNumber);

//    진로정보 글 전체 좋아요순 및 카테고리 별 조회하기
    List<CareerInfoVo> selectCareerInfoList(List<Integer> tagList);

//    진로정보 글 상세보기 진입 시 조회 수 증가
    void careerInfoReadCnt(Long careerInfoNumber);

//    진로정보 글 번호로 수정하기
    void careerInfoUpdate(CareerInfoDto careerInfoDto);

//    진로정보 글 번호로 삭제하기
    void careerInfoDelete(Long careerInfoNumber);
}
