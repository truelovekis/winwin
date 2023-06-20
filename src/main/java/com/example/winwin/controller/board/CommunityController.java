package com.example.winwin.controller.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mentormentee/*")
public class CommunityController {
    @GetMapping("/mentorProfile")
    public String mentorProfile(){
        return "mentormentee/mentorProfile";
    }
}
