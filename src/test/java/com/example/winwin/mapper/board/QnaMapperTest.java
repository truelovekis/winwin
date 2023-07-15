package com.example.winwin.mapper.board;

import com.example.winwin.dto.admin.AdminVo;
import com.example.winwin.dto.board.CommunityDto;
import com.example.winwin.dto.board.QnaDto;
import com.example.winwin.dto.board.QsBridgeDto;
import com.example.winwin.vo.board.QnaVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class QnaMapperTest {

    @Autowired
    private QnaMapper qnaMapper;
    private QnaDto qnaDto;
    private QsBridgeDto qsBridgeDto;

    @BeforeEach
    void setUp(){
        qnaDto = new QnaDto();
        qnaDto.setUserNumber(9L);
        qnaDto.setQnaContent("test");
        qnaDto.setQnaTitle("test");

        qsBridgeDto = new QsBridgeDto();
        qsBridgeDto.setSubNumber(qsBridgeDto.getSubNumber());
        qsBridgeDto.setSubName(qsBridgeDto.getSubName());
    }

    @Test
    void insert() {
        qnaMapper.insertQna(qnaDto);
//        qnaMapper.insertQs(qsBridgeDto);
        System.out.println("================================");
        System.out.println(qnaDto.getQnaNumber());
    }

    @Test
    void insert2(){
        qnaMapper.insertQs(qsBridgeDto);
    }


    @Test
    void selectQna() {
        QnaVo qnaVo = new QnaVo();
        qnaVo.setQnaContent("간호사");
        qnaVo.setQnaTitle("간호사");
//        qnaMapper.selectQna();
    }
}