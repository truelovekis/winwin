package com.example.winwin.controller.chatting;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Chat/*")
public class ChattingController {
    @GetMapping("/view")
    public String chatview(){
        return "chatting/notebox";
    }
    @GetMapping("/write")
    public String chatwrite(){
        return "chatting/Sendnote";
    }
}
