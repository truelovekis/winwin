package com.example.winwin.service.career;

import com.example.winwin.dto.mentor.CareerInfoVo;
import com.example.winwin.mapper.career.CareerInfoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Transactional
class CareerInfoServiceTest {

    @Mock
    private CareerInfoMapper careerInfoMapper;

    @InjectMocks
    private CareerInfoService careerInfoService;
    private CareerInfoVo careerInfoVo;

    @BeforeEach
    void setUp(){
        careerInfoVo = new CareerInfoVo();
        careerInfoVo.setCareerInfoTitle("title");
        careerInfoVo.setCareerInfoContent("content");
        careerInfoVo.setMentorNumber(8L);

//        careerInfoMapper.careerInfoInsert(careerInfoVo);
    }

    @Test
    @DisplayName("진로정보 좋아요순 및 카테고리 별 조회하기")
    void findCareerInfoList() {
        List<Integer> tagList = List.of(11, 173);

//        doReturn(List.of(careerInfoVo)).when(careerInfoMapper).selectCareerInfoList(any(List.class), an);

//        List<CareerInfoVo> careerInfoVoList = careerInfoService.findCareerInfoList(tagList);

//        assertThat(careerInfoVoList).contains(careerInfoVo);
    }
}