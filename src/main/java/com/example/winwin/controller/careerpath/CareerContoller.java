package com.example.winwin.controller.careerpath;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/career/*")
public class CareerContoller {

//    진로정보 메인페이지 단순이동
    @GetMapping("/list")
    public String careerpathForm(){
        return "careerpath/careerInfo";
    }

//    진로정보 페이지 상세페이지 단순이동
    @GetMapping("detail")
    public String careerDetail(){
        return "careerpath/careerInfoDetail";
    }

//    진로정보 글 작성하기 페이지 단순이동
    @GetMapping("/write")
    public String careerlyWrite (){

        return "careerpath/careerlyWrite";
    }
}
