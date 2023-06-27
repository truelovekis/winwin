package com.example.winwin.controller.meeting;

import com.example.winwin.dto.board.StudyDto;
import com.example.winwin.service.board.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/meeting/*")
public class meetingController {
    private final StudyService studyService;

    @GetMapping("/home")
    public String meetingHomeForm(Model model){
        List<StudyDto> projectList = studyService.findMainList();
        System.out.println(projectList);
        model.addAttribute("projectList", projectList);
        return "meeting/home";
    }

    @GetMapping("/meeting")
    public String meetingMeetingForm(){
        return "meeting/meeting";
    }
}