package com.example.winwin.controller.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project/*")
@RequiredArgsConstructor
public class projectController {
    @GetMapping("/read")
    public String projectRead (){
        return "/project/projectRead";
    }

    @GetMapping("/write")
    public String projectWrite(){
        return "/project/projectWrite";
    }
}
