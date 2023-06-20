package com.example.winwin.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/MentorProfile/*")
public class MentorController {

    @GetMapping("/Apply")
    public String Apply (){
        return "mentorProfile/Apply";
    }

    @GetMapping("/DefaultProfile")
    public String Default (){
        return "mentorProfile/DefaultProfile";
    }

    @GetMapping("/Introduceyourself")
    public String intro (){
        return "mentorProfile/Introduceyourself";
    }

    @GetMapping("/skillUpdate")
    public String skill (){
        return "mentorProfile/skillUpdate";
    }

    @GetMapping("/specUpdate")
    public String spec (){
        return "mentorProfile/specUpdate";
    }
}
