//package com.example.winwin.controller.mentor;
//
//import com.example.winwin.dto.mentor.MentorVo;
//import com.example.winwin.service.mentor.MentorService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(MentorController.class)
//class MentorControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private MentorService mentorService;
//    private MentorVo mentorVo;
//
//    @BeforeEach
//    void setUp(){
//        mentorVo = new MentorVo();
//        mentorVo.setSkillName("JAVA");
//        mentorVo.setCareerCompany("삼성");
//        mentorVo.setUserName("홍길동");
//        mentorVo.setCareerTitle("백엔드");
//        mentorVo.setCareerStartDate("2012.06.26");
//        mentorVo.setCareerEndDate("2016.05.14");
//    }
//
//    @Test
//    void mentorList() throws Exception {
//        doReturn(List.of(mentorVo)).when(mentorService).findList();
//        mockMvc.perform(MockMvcRequestBuilders.get("/mentor/list"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//
////    @Test
////    void mentorSkill(Long mentorNumber) throws Exception {
////        doReturn(List.of(mentorVo)).when(mentorService).findSkill(mentorNumber);
////        mockMvc.perform(MockMvcRequestBuilders.get("/mentor/list/{mentorNumber}"))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////
////    }
//
//    @Test
//    void profile() {
//    }
//
//    @Test
//    void apply() {
//    }
//
//    @Test
//    void defaultProfile() {
//    }
//
//    @Test
//    void self() {
//    }
//}