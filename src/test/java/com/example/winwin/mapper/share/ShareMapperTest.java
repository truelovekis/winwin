package com.example.winwin.mapper.share;

import com.example.winwin.dto.share.ShareDto;
import com.example.winwin.dto.user.UserDto;
import com.example.winwin.mapper.user.UserMapper;
import com.example.winwin.vo.share.ShareVo;
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
class ShareMapperTest {

    @Autowired
    private ShareMapper shareMapper;
    @Autowired
    private UserMapper userMapper;
    private ShareDto shareDto;
    private UserDto userDto;
    private ShareVo shareVo;

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
        userDto.setUserGender("1");
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
    }

    @Test
    @DisplayName("나눔 글 번호로 조회하기")
    void shareInsert() {
        System.out.println("=====================================");
        System.out.println(shareDto);
        System.out.println("=====================================");
        ShareVo foundShare = shareMapper.shareSelectNumber(shareDto.getShareNumber());

        System.out.println(foundShare);

        assertThat(foundShare.getShareNumber()).isEqualTo(shareDto.getShareNumber());

    }

    @Test
    @DisplayName("나눔 글 전체 최신순으로 조회하기")
    void shareSelectAll() {
        int shareSize = shareMapper.shareSelectAll().size();

        shareMapper.shareInsert(shareDto);

        assertThat(shareMapper.shareSelectAll().size()).isEqualTo(shareSize + 1);
    }

    @Test
    @DisplayName("나눔 글 번호로 수정하기")
    void shareUpdate() {
        shareDto.setShareTitle("title update");
        shareDto.setShareContent("content update");

        shareMapper.shareUpdate(shareDto);

        assertThat(shareMapper.shareSelectNumber(shareDto.getShareNumber()).getShareTitle())
                .isEqualTo(shareDto.getShareTitle());
    }

    @Test
    @DisplayName("나눔 글 번호로 삭제하기")
    void shareDelete() {
        shareMapper.shareDelete(shareDto.getShareNumber());

        assertThat(shareMapper.shareSelectNumber(shareDto.getShareNumber())).isNull();
    }
}