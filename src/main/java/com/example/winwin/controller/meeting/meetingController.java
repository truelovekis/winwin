package com.example.winwin.controller.meeting;

import com.example.winwin.service.board.StudyService;
import com.example.winwin.vo.board.StudyVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/meeting/*")
@RequiredArgsConstructor
public class meetingController {

    private final StudyService studyService;

    @GetMapping("/home")
    public String meetingHomeForm(Model model){
        List<StudyVo> projectList = studyService.findMainList(1);
        List<StudyVo> studyList = studyService.findMainList(2);
        System.out.println(projectList);
        model.addAttribute("projectList", projectList);
        model.addAttribute("studyList", studyList);

        return "meeting/projecthome";
    }

    @GetMapping("/meeting")
    public String otherProjectForm(Integer categoryNumber, Model model){
        categoryNumber = categoryNumber == null ? 0 : categoryNumber;
        List<StudyVo> projectList = studyService.otherProjectList(categoryNumber);
        System.out.println(projectList);
        model.addAttribute("projectList", projectList);

        return "meeting/projectmeeting";
    }

    @GetMapping("/meetingproject")
    public String meetingproject(Long studyNumber, Model model) {
        StudyVo studyVo = studyService.studyFind(studyNumber);
        model.addAttribute("studyVo", studyVo);
        return "/meeting/meeting";
    }

}