package com.example.winwin.controller.mentor;

import com.example.winwin.dto.chatting.ChattingDto;
import com.example.winwin.dto.mentor.CareerVo;
import com.example.winwin.dto.mentor.LikeDto;
import com.example.winwin.dto.mentor.MentorVo;
import com.example.winwin.dto.mentor.SkillVo;
import com.example.winwin.service.chatting.ChattingService;
import com.example.winwin.service.mentor.MentorService;
import com.example.winwin.service.myPage.UserMentorService;
import com.sun.jdi.connect.spi.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mentor/*")
public class MentorStatusController {
    private final MentorService mentorService;
    private final UserMentorService userMentorService;
    private final ChattingService chattingService;

    @PatchMapping("/list")
    public void mentorModify(String mentorStatus, HttpServletRequest req, RedirectAttributes redirectAttributes){
        Long mentorNumber = (Long)req.getSession().getAttribute("mentorNumber");
        System.out.println("=====================================");
        System.out.println(mentorStatus);
        MentorVo mentorVo = new MentorVo();
        mentorVo.setMentorStatus(mentorStatus);
        mentorVo.setMentorNumber(mentorNumber);
        mentorService.modifyMentor(mentorVo);
//        redirectAttributes.addFlashAttribute("mentorNumber", mentorNumber);
    }

    @PostMapping("/like")
    public String registerLike(LikeDto likeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        System.out.println("=============================================");
        System.out.println(likeDto.getMentorNumber());
        likeDto.setUserNumber(userNumber);
        mentorService.registerLike(likeDto);
        return "찜하기 성공!";
    }

    @DeleteMapping("/delete")
    public String removeLike(LikeDto likeDto, HttpServletRequest req){
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        likeDto.setUserNumber(userNumber);
        mentorService.removeLike(likeDto);
        return "삭제 성공!";
    }

    @PostMapping("/add")
    public String registerMentor(MentorVo mentorVo, HttpServletRequest req){
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        System.out.println(mentorVo.getMentorNumber());
        mentorVo.setUserNumber(userNumber);
        mentorService.addMentor(mentorVo);
        return "신청 성공!";
    }

    @GetMapping("/sub")
    public List<MentorVo> subCategory(HttpServletRequest req, @RequestParam(value = "subNumber", required = false) List<Integer> subList){
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        List<MentorVo> mentorVo = mentorService.findList(userNumber==null? 0 : userNumber, subList);
        return mentorVo;
    }

    @GetMapping("/skill2")
    public List<SkillVo> skillList(Long mentorNumber){
        List<SkillVo> skillVo = mentorService.findSkill(mentorNumber);
        return skillVo;
    }

    @GetMapping("/career2")
    public List<CareerVo> careerList(Long mentorNumber){
        List<CareerVo> careerVo = mentorService.findCareerList(mentorNumber);
        return careerVo;
    }

    @GetMapping("/profile2")
    public MentorVo findProfile(Long mentorNumber){
        MentorVo mentorVo = new MentorVo();
        mentorVo.setMentorNumber(mentorNumber);
        return mentorService.findPfp(mentorNumber);
    }

    //    멘티 수락하기
    @PatchMapping("/okmentee")
    public void okum(MentorVo mentorVo, HttpServletRequest req){
        Long mentorNumber = (Long) req.getSession().getAttribute("mentorNumber");
        mentorVo.setMentorNumber(mentorNumber);

        userMentorService.okMentee(mentorVo);
    }

//    멘티 거절하기
    @DeleteMapping("/nomentee")
    public List<MentorVo> noum(MentorVo mentorVo, HttpServletRequest req){
        Long mentorNumber = (Long) req.getSession().getAttribute("mentorNumber");
        mentorVo.setMentorNumber(mentorNumber);
        userMentorService.noMentee(mentorVo);
        return userMentorService.findMentee(mentorNumber);
    }

    @PostMapping("/inputModal")
    public void sendChatting(@RequestBody ChattingDto chattingDto, HttpServletRequest req){
        Long chattingFrom = (Long)req.getSession().getAttribute("userNumber");
        chattingDto.setChattingFrom(chattingFrom);

        System.out.println(chattingDto);
        chattingService.sendChatting(chattingDto);
    }
}
