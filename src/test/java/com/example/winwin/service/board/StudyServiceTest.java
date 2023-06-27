package com.example.winwin.service.board;

import com.example.winwin.dto.board.StudyDto;
import com.example.winwin.dto.user.UserDto;
import com.example.winwin.mapper.board.StudyMapper;
import com.example.winwin.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
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
@Slf4j
class StudyServiceTest {

    @Mock
    private StudyMapper studyMapper;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private StudyService studyService;
    private StudyDto studyDto;
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
        userDto.setUserIdentity("W");
        userDto.setUserNickname("웅이");
        userDto.setUserGender(1);
        userDto.setUserGrade(5);
        userDto.setUserWing(100L);

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

    }

    @Test
    @DisplayName("게시글 등록하기")
    void studyRegister() {
        doNothing().when(studyMapper).studyInsert(any(StudyDto.class));

        studyService.studyRegister(studyDto);

        verify(studyMapper, times(1)).studyInsert(studyDto);
    }

    @Test
    @DisplayName("게시글 번호로 삭제하기")
    void studyRemove() {
        doNothing().when(studyMapper).studyDelete(any(Long.class));
        studyService.studyRemove(1L);
        verify(studyMapper, times(1)).studyDelete(1L);
    }

    @Test
    @DisplayName("게시글 번호로 수정하기")
    void studyModify() {
        doNothing().when(studyMapper).studyUpdate(any(StudyDto.class));
        studyService.studyModify(studyDto);
        verify(studyMapper, times(1)).studyUpdate(studyDto);
    }

    @Test
    @DisplayName("게시글 번호로 상세보기")
    void studyFind() {
        doReturn(studyDto).when(studyMapper).studySelect(any(Long.class));
        StudyDto foundDto = studyService.studyFind(1L);
        assertThat(foundDto.getStudyContent()).isEqualTo(studyDto.getStudyContent());
    }

    @Test
    @DisplayName("게시글 전체 조회")
    void findMainList() {
        doReturn(List.of(studyDto)).when(studyMapper).mainSelect();
        List<StudyDto> foundList = studyService.findMainList();
        assertThat(foundList.size()).isEqualTo(1);
    }
}