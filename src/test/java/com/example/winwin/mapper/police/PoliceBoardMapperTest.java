package com.example.winwin.mapper.police;

import com.example.winwin.dto.police.PoliceBoardDto;
import com.example.winwin.dto.share.ShareDto;
import com.example.winwin.dto.user.UserDto;
import com.example.winwin.mapper.share.ShareMapper;
import com.example.winwin.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class PoliceBoardMapperTest {

    @Autowired
    private PoliceBoardMapper policeBoardMapper;
    @Autowired
    private ShareMapper shareMapper;
    @Autowired
    private UserMapper userMapper;

    private PoliceBoardDto policeBoardDto;
    private ShareDto shareDto;
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
        userDto.setUserGender("3");
        userDto.setUserGrade(5);
        userDto.setUserWing(300L);

        userMapper.join(userDto);

        shareDto = new ShareDto();
        shareDto.setShareTitle("title");
        shareDto.setShareContent("content");
        shareDto.setShareWing(300);
        shareDto.setShareStatus("1");
        shareDto.setUserNumber(userDto.getUserNumber());

        shareMapper.shareInsert(shareDto);

        policeBoardDto = new PoliceBoardDto();
        policeBoardDto.setBigCode("600");
        policeBoardDto.setBoardNumber(shareDto.getShareNumber());
        policeBoardDto.setPoliceCategory(1L);
        policeBoardDto.setUserNumber(userDto.getUserNumber());

        policeBoardMapper.reportInsert(policeBoardDto);
    }

    @Test
    @DisplayName("게시글 번호로 신고항목 조회하기")
    void shareReportSelect(){
        PoliceBoardDto foundBoard = policeBoardMapper.shareReportSelect(policeBoardDto.getBoardNumber());

        assertThat(foundBoard.getBoardNumber()).isEqualTo(policeBoardDto.getBoardNumber());
    }

    @Test
    @DisplayName("나눔 글 삭제 시 신고항목 삭제 테스트")
    void shareReportDelete(){
        policeBoardMapper.shareReportDelete(policeBoardDto.getBoardNumber());

        assertThat(policeBoardMapper.shareReportSelect(policeBoardDto.getBoardNumber())).isNull();
    }

}