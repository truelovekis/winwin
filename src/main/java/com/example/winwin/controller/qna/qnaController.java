package com.example.winwin.controller.qna;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna/*")
@RequiredArgsConstructor
public class qnaController {
    @GetMapping("/read")
    public String qnaRead(){
        return "/qna/qnaRead";
    }

    @GetMapping("/write")
    public String qnaWrite(){
        return "/qna/qnaWrite";
    }
}
