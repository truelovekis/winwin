package com.example.winwin.mapper.admin;

import com.example.winwin.dto.admin.*;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@SpringBootTest
@Transactional
class AdminMapperTest {

    @Autowired
    private AdminMapper adminMapper;

    private AdminVo adminVo;


    @Test
    @DisplayName("검색한 회원 조회")
    void getUserInfo() {
        AdminUserSearchVo adminUserSearchVo = new AdminUserSearchVo();
        adminUserSearchVo.setMainCode("104");
        adminUserSearchVo.setIdentity("U");
//        adminUserSearchVo.setMentor("1");
        adminUserSearchVo.setId("e");

        List<AdminVo> list = adminMapper.getUserInfo(adminUserSearchVo);

        System.out.println(list);
    }

    @Test
    @DisplayName("전체 회원 조회")
    void selectTest(){
        AdminVo adminVo = new AdminVo();
        adminVo.setUserId("estherk773");
        adminMapper.selectTest(adminVo);
    }


    @Test
    @DisplayName("전체 게시판 조회")
    void selectBoard(){
        AdminVo adminVo = new AdminVo();
        adminVo.setCommunityTitle("도저히 모르겠어요");
        adminVo.setCategoryNumber(20);
        adminMapper.selectBoard();
    }

    @Test
    @DisplayName("검색한 게시판 조회")
    void selectSearchBoard(){
        AdminBoardSearchVo adminBoardSearchVo = new AdminBoardSearchVo();
        adminBoardSearchVo.setName("김에스더");
        adminBoardSearchVo.setCategoryCode("20");
  //      adminBoardSearchVo.setCommunityDate("2023-06-23");
//        adminBoardSearchVo.setStatus("1");

        List<AdminVo> list = adminMapper.selectSearchBoard(adminBoardSearchVo);

        System.out.println(list);
    }


    @Test
    @DisplayName("전체 윙 조회")
    void selectWing(){
        AdminVo adminVo = new AdminVo();
        adminVo.setUserId("estherk773");
        adminVo.setUserName("김에스더");
        adminVo.setUserWing(30);

        adminMapper.selectWing(adminVo);
    }

    @Test
    @DisplayName("검색한 윙 조회")
    void selectSearchWing(){
        AdminWingSearchVo adminWingSearchVo = new AdminWingSearchVo();
        adminWingSearchVo.setName("김에스더");
//        adminWingSearchVo.setId("estherk773");
//        adminWingSearchVo.setDate("2023-06-23, YYYY-MM-DD");
   //     adminWingSearchVo.setMentor("0");

        List<AdminVo> list = adminMapper.selectSearchWing(adminWingSearchVo);

        System.out.println(list);
    }


    @Test
    @DisplayName("전체 진로정보 조회")
    void selectCareer(){
        AdminVo adminVo = new AdminVo();
        adminVo.setUserName("김에스더");
        adminVo.setCareerInfoTitle("간호사 되는 꿀팁");

        adminMapper.selectCareer();
    }

    @Test
    @DisplayName("검색한 진로정보 조회")
    void selectSearchCareer(){
        AdminCareerSearchVo adminCareerSearchVo = new AdminCareerSearchVo();
        adminCareerSearchVo.setName("김에스더");
        adminCareerSearchVo.setCode("104");
       adminCareerSearchVo.setDate("2023-06-25");
       adminCareerSearchVo.setStatus("1");

        List<AdminVo> list = adminMapper.selectSearchCareer(adminCareerSearchVo);

        System.out.println(list);
    }

    @Test
    @DisplayName("전체 나눔 조회")
    void selectShare(){
        AdminVo adminVo = new AdminVo();
        adminVo.setUserName("김에스더");
        adminVo.setShareTitle("아이패드 팔아요");

        adminMapper.selectShare();
    }

    @Test
    @DisplayName("검색한 나눔 조회")
    void selectSearchShare(){
        AdminShareSearchVo adminShareSearchVo = new AdminShareSearchVo();
        adminShareSearchVo.setName("김에스더");
        adminShareSearchVo.setTitle("아이패드 팔아요");
        adminShareSearchVo.setShareDate("2023-06-28");
//        adminShareSearchVo.setStatus("1");

        List<AdminVo> list = adminMapper.selectSearchShare(adminShareSearchVo);

        System.out.println(list);
    }



//    @Test
//    @DisplayName("전체 신고 조회")
//    void selectReport(){
//        AdminVo adminVo = new AdminVo();
//        adminVo.setUserId("estherk773");
//        adminVo.setUserName("김에스더");
//
//        adminMapper.selectReport();
//    }

    @Test
    @DisplayName("검색한 신고 조회")
    void selectSearchReport(){
        AdminReportSearchVo adminReportSearchVo = new AdminReportSearchVo();
        adminReportSearchVo.setName("김에스더");
        adminReportSearchVo.setBigCode("커뮤니티");
        adminReportSearchVo.setCode(1L);
      adminReportSearchVo.setStatus("2");

        List<AdminVo> list = adminMapper.selectSearchReport(adminReportSearchVo);

        System.out.println(list);
    }


    @Test
    @DisplayName("커뮤니티 상태 변경")
    void updateStatus() {
        Long communityNumber = 9L;
        adminMapper.updateStatus(communityNumber, "0");

        List<AdminVo> list = adminMapper.selectBoard();

        for(AdminVo vo : list){
            if(vo.getCommunityNumber() == communityNumber){
                System.out.println(vo);
                assertThat(vo.getCommunityStatus()).isEqualTo("0");
            }
        }

    }

    @Test
    @DisplayName("진로정보 상태 변경")
    void updateCareer() {
        Long careerInfoNumber = 1L;
        adminMapper.updateCareer(careerInfoNumber, "1");

        List<AdminVo> list = adminMapper.selectCareer();

        for(AdminVo vco : list){
            if(vco.getCareerInfoNumber() == careerInfoNumber){
                System.out.println(vco);
                assertThat(vco.getCareerInfoStatus()).isEqualTo("1");
            }
        }

    }

    @Test
    @DisplayName("나눔 상태 변경")
    void updateShare(){
        Long shareNumber = 1L;
        adminMapper.updateShare(shareNumber, "1");

        List<AdminVo> list = adminMapper.selectShare();

        for (AdminVo vooo : list){
            if(vooo.getShareNumber() == shareNumber){
                System.out.println(vooo);
                assertThat(vooo.getShareStatus()).isEqualTo("1");
            }
        }
    }

    @Test
    @DisplayName("신고회원 상태 변경")
    void updateReport() {
//        Long userNumber = 5L;
//        adminMapper.updateReport(userNumber, "1");
//
//        List<AdminVo> list = adminMapper.selectReport();
//
//        for(AdminVo voo : list){
//            if(voo.getUserNumber() == userNumber){
//                System.out.println(voo);
//                assertThat(voo.getUserStatus()).isEqualTo("1");
//            }
//        }
    }



}