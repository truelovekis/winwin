package com.example.winwin.controller.board;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/community/*")
@RequiredArgsConstructor
public class CommunityController {

    @GetMapping("/main")
    public String communityMain(){
        return "/community/communityMain";
    }

    @GetMapping("write")
    public String communityWrite(){
        return "/community/communityWrite";
    }

    @GetMapping("/share")
    public String shareMain(){
        return "/share/share";
    }

    @GetMapping("/shareWrite")
    public String shareWrite(){
        return "/share/shareWrite";
    }

    @GetMapping("/qna")
    public String qna(){
        return "/qna/qna";
    }

    @GetMapping("/myDiary")
    public String mypage(){
        return "/mypage/mypageDiary";
    }

    @GetMapping("/mentorProfile")
    public String mentorProfile(){
        return "mentormentee/mentorProfile";
    }

    @GetMapping("/read")
    public String board (){
        return "/community/communityRead";
    }
}
