package com.example.winwin.controller.careerpath;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/careerpath/*")
@RequiredArgsConstructor

public class careerlyWriteController {
    @GetMapping("/write")
    public String careerlyWrite (){

        return "/careerpath/careerlyWrite";
    }
}
