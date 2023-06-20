package com.example.winwin.controller.careerpath;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/careerpath/*")
public class careerpath {
    @GetMapping
    public String careerpathForm(){
        return "careerpath/careerpath";
    }
}
