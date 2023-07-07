package com.example.winwin.service.career;

import com.example.winwin.dto.careerInfo.CareerInfoDto;
import com.example.winwin.dto.mentor.CareerInfoVo;
import com.example.winwin.dto.mentor.CategoryVo;
import com.example.winwin.mapper.career.CareerInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CareerInfoService {

    private final CareerInfoMapper careerInfoMapper;

//    진로정보 글 등록하기
    public void careerInfoRegister(CareerInfoVo careerInfoVo){
        if (careerInfoVo == null){
            throw new IllegalArgumentException("진로정보 페이지 글 정보가 누락되었습니다.");
        }

        careerInfoMapper.careerInfoInsert(careerInfoVo);
    }

//    진로정보 멘토번호 찾기
    public Long findMentorNumber(Long userNumber){
        if (userNumber == null){
            throw new IllegalArgumentException("회원번호가 일치하지 않습니다.");
        }

        return Optional.ofNullable(careerInfoMapper.selectMentorNumber(userNumber))
                .orElseThrow(()->{
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });
    }

//    진로정보 멘토 인증태그 찾기
    public List<CategoryVo> findMentorTag(Long userNumber){
        if (userNumber == null){
            throw new IllegalArgumentException("회원번호가 일치하지 않습니다.");
        }

        return careerInfoMapper.selectMentorTag(userNumber);
    }

//    진로정보 글 번호로 조회하기
    @Transactional(readOnly = true)
    public CareerInfoDto findCareerInfo(Long careerInfoNumber){
        if (careerInfoNumber == null){
            throw new IllegalArgumentException("진로정보 글 번호가 일치하지 않습니다.");
        }

        return Optional.ofNullable(careerInfoMapper.careerInfoSelectNumber(careerInfoNumber))
                .orElseThrow(()->{
                    throw new IllegalArgumentException("존재하지 않는 진로정보 글 입니다.");
                });
    }

//    진로정보 글 전체 좋아요순 및 카테고리 별 조회하기
    @Transactional(readOnly = true)
    public List<CareerInfoVo> findCareerInfoList(List<Integer> tagList){
        if (tagList == null){
            throw new IllegalArgumentException("카테고리 정보가 누락되었습니다.");
        }

        return Optional.ofNullable(careerInfoMapper.selectCareerInfoList(tagList))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 카테고리 입니다.");
                });
    }

//    진로정보 글 상세보기 진입 시 조회 수 증가
    public void careerInfoReadUpdate(Long careerInfoNumber){
        if (careerInfoNumber == null){
            throw new IllegalArgumentException("진로정보 글 번호가 일치하지 않습니다.");
        }

        careerInfoMapper.careerInfoReadCnt(careerInfoNumber);
    }

//    진로정보 글 번호로 수정하기
    public void careerInfoModify(CareerInfoDto careerInfoDto){
        if (careerInfoDto == null){
            throw new IllegalArgumentException("진로정보 페이지 글 정보가 누락되었습니다.");
        }

        careerInfoMapper.careerInfoUpdate(careerInfoDto);
    }

//    진로정보 글 번호로 삭제하기
    public void careerInfoRemove(Long careerInfoNumber){
        if(careerInfoNumber == null){
            throw new IllegalArgumentException("진로정보 글 번호가 일치하지 않습니다.");
        }

        careerInfoMapper.careerInfoDelete(careerInfoNumber);
    }
}
