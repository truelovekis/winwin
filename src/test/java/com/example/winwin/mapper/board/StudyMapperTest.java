package com.example.winwin.mapper.board;

import com.example.winwin.dto.board.StudyDto;
import com.example.winwin.dto.user.UserDto;
import com.example.winwin.mapper.user.UserMapper;
import com.example.winwin.vo.board.StudyVo;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class StudyMapperTest {

    @Autowired
    private StudyMapper studyMapper;
    private StudyDto studyDto;
    private StudyVo studyVo;


    @Autowired
    private UserMapper userMapper;
    private UserDto userDto;


    @BeforeEach
    void setUp(){
        userDto = new UserDto();
        userDto.setUserName("박웅이");
        userDto.setUserId("eee");
        userDto.setUserPassword("1234");
        userDto.setUserEmail("eee@gmail.com");
        userDto.setUserRrnumber("940406");
        userDto.setUserBelong("배달의 민족");
        userDto.setUserNickname("웅이");
        userDto.setUserPhoneNumber("01012341234");
        userDto.setUserGrade(5);
        userDto.setUserWing(100L);

        userMapper.join(userDto);

        studyDto = new StudyDto();
        studyDto.setStudyTitle("글머리");
        studyDto.setStudyContent("내용");
        studyDto.setStudySummaryTitle("요약제목");
        studyDto.setStudySummaryContent("요약내용");
        studyDto.setStudyRole("백엔드");
        studyDto.setStudyStatus("1");
        studyDto.setStudyOpenlink("kakao");
        studyDto.setUserNickname("고기");
        studyDto.setUserNumber(userDto.getUserNumber());
        studyDto.setCategoryNumber(1L);
        studyDto.setPurposeNumber(1L);
        studyDto.setTimeNumber(1L);
        studyDto.setStudyReadCnt(0L);
        studyDto.setUserNumber(userDto.getUserNumber());

        studyMapper.studyInsert(studyDto);

        studyVo = new StudyVo();
        studyVo.setStudyTitle("글머리");
        studyVo.setStudyContent("내용");
        studyVo.setStudySummaryTitle("요약제목");
        studyVo.setStudySummaryContent("요약내용");
        studyVo.setStudyRole("백엔드");
        studyVo.setStudyStatus("1");
        studyVo.setStudyOpenlink("kakao");
        studyVo.setUserNickname("고기");
        studyVo.setUserNumber(userDto.getUserNumber());
        studyVo.setCategoryNumber(1L);
        studyVo.setPurposeNumber(1L);
        studyVo.setTimeNumber(1L);
        studyVo.setStudyReadCnt(0L);
        studyVo.setUserNumber(userDto.getUserNumber());
        studyVo.setLikeCnt(1);
        studyVo.setUserNumber(1L);


    }

    @Test
    @DisplayName("프로젝트, 모임 메인페이지 슬라이드 글")
    void mainSelect(){
        int size = studyMapper.mainSelect(1).size();

        studyMapper.studyInsert(studyDto);

        assertThat(studyMapper.mainSelect(1).size()).isEqualTo(size + 1);
    }

    @Test
    @DisplayName("프로젝트,모임 게시물 삭제")
    void studyDelete() {
        studyMapper.studyDelete(studyDto.getStudyNumber());

        assertThat(studyMapper.studySelect(studyDto.getStudyNumber())).isNull();
    }

    @Test
    @DisplayName("프로젝트,모임 게시물 수정")
    void studyUpdate() {
        studyDto.setStudyTitle("test title");
        studyDto.setStudyContent("test content");

        studyMapper.studyUpdate(studyDto);

        assertThat(studyMapper.studySelect(studyDto.getStudyNumber()).getStudyTitle())
                .isEqualTo(studyDto.getStudyTitle());
    }

    @Test
    @DisplayName("게시글 상세보기")
    void studySelect(){
        StudyVo foundStudy = studyMapper.studySelect(studyVo.getStudyNumber());

        assertThat(foundStudy.getStudyNumber()).isEqualTo(studyVo.getStudyNumber());
    }

}