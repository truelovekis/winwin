package com.example.winwin.mapper.career;

import com.example.winwin.dto.mentor.CareerInfoVo;
import com.example.winwin.dto.mentor.MentorVo;
import com.example.winwin.dto.user.UserDto;
import com.example.winwin.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class CareerInfoMapperTest {

    @Autowired
    private CareerInfoMapper careerInfoMapper;
    private CareerInfoVo careerInfoVo;


    @BeforeEach
    void setUp(){
        careerInfoVo = new CareerInfoVo();
        careerInfoVo.setCareerInfoTitle("title");
        careerInfoVo.setCareerInfoContent("content");
        careerInfoVo.setMentorNumber(8L);

        careerInfoMapper.careerInfoInsert(careerInfoVo);
    }

    @Test
    @DisplayName("진로정보 리스트 불러오기")
    void selectCareerInfoList() {
        List<Integer> tagList = List.of(11,173);

        System.out.println("========" + tagList);

        careerInfoMapper.careerInfoInsert(careerInfoVo);

        int careerInfoSize = careerInfoMapper.selectCareerInfoList(tagList).size();


        assertThat(careerInfoMapper.selectCareerInfoList(tagList).size()).isEqualTo(careerInfoSize);

    }
}