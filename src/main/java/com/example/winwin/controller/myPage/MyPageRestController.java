package com.example.winwin.controller.myPage;

import com.example.winwin.dto.user.ResumePrDto;
import com.example.winwin.service.myPage.MyPageService;
import com.example.winwin.vo.myPage.ResumeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/myPages/*")
public class MyPageRestController {
    private final MyPageService myPageService;

    @GetMapping("/resume")
    public ResumeVo getResume(HttpServletRequest req, Long resumeNumber){
        if(resumeNumber == null){
            throw new IllegalArgumentException("존재하지 않는 이력서입니다.");
        }
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        ResumeVo resumeVo = new ResumeVo();

        resumeVo.setResumeDto(myPageService.getResume(resumeNumber));
//        resumeVo.setUserPhoneNumber(myPageService.getPhoneNumber(userNumber));
        resumeVo.setUserPhoneNumber(myPageService.getPhoneNumber(1L));

        return resumeVo;
    }

    @GetMapping("/pr")
    public void getPr(HttpServletRequest req, Long prNumber){
        if(prNumber == null){
            throw new IllegalArgumentException("존재하지 않는 자기소개서입니다.");
        }

        ResumePrDto resumePrDto = myPageService.getPr(prNumber);
        req.getSession().setAttribute("pr", resumePrDto);
    }
}
