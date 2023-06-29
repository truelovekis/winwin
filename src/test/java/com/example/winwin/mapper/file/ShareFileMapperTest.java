package com.example.winwin.mapper.file;

import com.example.winwin.dto.file.ShareFileDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class ShareFileMapperTest {

    @Autowired
    private ShareFileMapper shareFileMapper;
    private ShareFileDto shareFileDto;

    @BeforeEach
    void setUp(){
        shareFileDto = new ShareFileDto();
        shareFileDto.setFileSystemName("SystemName");
        shareFileDto.setFileUuid("uuid");
        shareFileDto.setFileUploadPath("23/01/01");
        shareFileDto.setShareNumber(133L);
    }

    @Test
    @DisplayName("나눔 글 파일 등록, 나눔 글 번호로 삭제하기 ")
    void shareFileDelete() {
        shareFileMapper.shareFileInsert(shareFileDto);
        shareFileMapper.shareFileDelete(shareFileDto.getShareNumber());

        assertThat(shareFileMapper.shareFileList(shareFileDto.getShareNumber()).size()).isEqualTo(0);
    }


}
