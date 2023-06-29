package com.example.winwin.controller.careerpath;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/career/*")
public class careerpath {

    @GetMapping("/list")
    public String careerpathForm(){
        return "careerpath/careerpath";
    }

    @GetMapping("detail")
    public String careerDetail(){
        return "careerpath/careerpathdetail";
    }


}
