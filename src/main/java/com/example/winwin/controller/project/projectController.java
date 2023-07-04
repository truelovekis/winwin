package com.example.winwin.controller.project;

import com.example.winwin.dto.board.StudyDto;
import com.example.winwin.service.board.StudyService;
import com.example.winwin.vo.board.StudyVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/project/*")
@RequiredArgsConstructor
public class projectController {

    private final StudyService studyService;

    @GetMapping("/read")
    public String projectRead(Long studyNumber, Model model) {
       StudyVo studyVo = studyService.studyFind(studyNumber);
        model.addAttribute("studyVo", studyVo);
        return "/project/projectRead";
    }

    @GetMapping("/modify")
    public String update2(Long studyNumber, Model model){
        StudyVo studyVo = studyService.studyFind(studyNumber);
        model.addAttribute("studyVo", studyVo);
        return "/project/projectModify";
    }

    @PostMapping("/modify")
    public RedirectView update(StudyVo studyVo, RedirectAttributes redirectAttributes){
        studyService.studyModify(studyVo);
        redirectAttributes.addAttribute("studyNumber", studyVo.getStudyNumber());
        return new RedirectView("/project/write");
    }

    @PostMapping("/delete")
    public String delete(StudyDto studyDto){
        studyService.studyRemove(1L);
        return "/project/home";
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
