package com.example.winwin.controller.inquiry;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inquiry/*")
@RequiredArgsConstructor
public class inquiryController {
    @GetMapping("/write")
    public String inquiry(){
        return "/inquiry/inquiryWrite";
    }
}
