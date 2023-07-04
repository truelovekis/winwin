//package com.example.winwin.service.user;
//
//import com.example.winwin.dto.mentor.MentorVo;
//import com.example.winwin.mapper.mentor.MentorMapper;
//import com.example.winwin.service.mentor.MentorService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class MentorServiceTest {
//
//    @Mock
//    private MentorMapper mentorMapper;
//
//    @InjectMocks
//    private MentorService mentorService;
//
//    private MentorVo mentorVo;
//
//    @BeforeEach
//    void setUp(){
//        mentorVo = new MentorVo();
//        mentorVo.setUserName("홍길동");
//        mentorVo.setCareerCompany("삼성");
//        mentorVo.setMentorNumber(1L);
//        mentorVo.setSkillName("JAVA");
//        mentorVo.setSkillName("HTML");
//
//    }
//
//
//    @Test
//    void findList() {
//    }
//
////    @Test
////    void findSkill() {
////        doReturn(mentorVo).when(mentorMapper).mentorSkill(any(Long.class));
////
////        List<MentorVo> found = mentorService.findSkill(1L);
////
////        assertThat(found).isEqualTo(mentorVo);
////    }
//
//    @Test
//    void findCareer() {
//    }
//}