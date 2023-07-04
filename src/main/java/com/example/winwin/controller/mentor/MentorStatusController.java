package com.example.winwin.controller.mentor;

import com.example.winwin.dto.mentor.LikeDto;
import com.example.winwin.dto.mentor.MentorVo;
import com.example.winwin.service.mentor.MentorService;
import com.sun.jdi.connect.spi.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mentor/*")
public class MentorStatusController {
    private final MentorService mentorService;

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
}
