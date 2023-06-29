package com.example.winwin.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {

    @GetMapping("/user")
    public String adminUser(){
        return "admin/adminUser";
    }

    @GetMapping("/board")
    public String adminBoard(){
        return "admin/adminBoard";
    }

    @GetMapping("/jobBoard")
    public String adminJobBoard(){
        return "admin/adminJobBoard";
    }

    @GetMapping("/point")
    public String adminPoint(){
        return "admin/adminPoint";
    }

    @GetMapping("/report")
    public String adminReport(){
        return "admin/adminReport";
    }

}
