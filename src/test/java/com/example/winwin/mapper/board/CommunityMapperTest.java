package com.example.winwin.mapper.board;

import com.example.winwin.dto.board.CommunityDto;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CommunityMapperTest {
    @Autowired
    private CommunityMapper communityMapper;
    private CommunityDto communityDto;

    @BeforeEach
    void setUp(){
        communityDto = new CommunityDto();
        communityDto.setUserNumber(9L);
        communityDto.setCommunityContent("test");
        communityDto.setCommunityTitle("test");
        communityDto.setCategoryNumber(10L);
    }

    @Test
    void insert() {
        communityMapper.insert(communityDto);
        System.out.println("================================");
        System.out.println(communityDto.getCommunityNumber());
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void select() {
    }

    @Test
    void selectAll() {
    }
}