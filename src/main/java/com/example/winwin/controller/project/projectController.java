package com.example.winwin.controller.project;

import com.example.winwin.dto.board.StudyDto;
import com.example.winwin.service.board.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/project/*")
@RequiredArgsConstructor
public class projectController {

    private final StudyService studyService;

    @GetMapping("/read")
    public String projectRead (){
        return "/project/projectRead";
    }

    @GetMapping("/write")
    public String projectWrite(){
        return "/project/projectWrite";
    }


    @PostMapping("/write")
    public RedirectView write(StudyDto studyDto, HttpServletRequest req){

        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

//        studyDto.setUserNumber(userNumber);
        studyDto.setUserNumber(1L);

        studyService.studyRegister(studyDto);
        System.out.println("==========123123==========");


        return new RedirectView("/meeting/home");
    }
}
