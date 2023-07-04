package com.example.winwin.mapper.career;

import com.example.winwin.dto.careerInfo.CareerInfoDto;
import com.example.winwin.dto.user.UserDto;
import com.example.winwin.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class CareerInfoMapperTest {

    @Autowired
    private CareerInfoMapper careerInfoMapper;
    @Autowired
    private UserMapper userMapper;
    private CareerInfoDto careerInfoDto;
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
        userDto.setUserGender("1");
        userDto.setUserGrade(5);
        userDto.setUserWing(300L);

        userMapper.join(userDto);

        careerInfoDto = new CareerInfoDto();
        careerInfoDto.setCareerInfoTitle("title");
        careerInfoDto.setCareerInfoContent("content");
        careerInfoDto.setUserNumber(userDto.getUserNumber());

        careerInfoMapper.careerInfoInsert(careerInfoDto);
    }

    @Test
    @DisplayName("진로정보 글 번호로 조회하기")
    void careerInfoSelectNumber() {
        CareerInfoDto foundCareer = careerInfoMapper.careerInfoSelectNumber(careerInfoDto.getCareerInfoNumber());

        assertThat(foundCareer.getCareerInfoNumber()).isEqualTo(careerInfoDto.getCareerInfoNumber());
    }

    @Test
    @DisplayName("진로정보 글 번호로 수정하기")
    void careerInfoUpdate() {
        careerInfoDto.setCareerInfoTitle("title20");
        careerInfoDto.setCareerInfoContent("content20");

        careerInfoMapper.careerInfoUpdate(careerInfoDto);

        assertThat(careerInfoMapper.careerInfoSelectNumber(careerInfoDto.getCareerInfoNumber()).getCareerInfoTitle())
                .isEqualTo(careerInfoDto.getCareerInfoTitle());
    }

    @Test
    @DisplayName("진로정보 글 번호로 삭제하기")
    void careerInfoDelete() {
        careerInfoMapper.careerInfoDelete(careerInfoDto.getCareerInfoNumber());

        assertThat(careerInfoMapper.careerInfoSelectNumber(careerInfoDto.getCareerInfoNumber())).isNull();
    }
}