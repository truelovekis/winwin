package com.example.winwin.controller.meeting;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/meeting/*")
public class meetingController {

    @GetMapping("/home")
    public String meetingHomeForm(){
        return "meeting/projecthome";
    }

    @GetMapping("/meeting")
    public String meetingMeetingForm(){
        return "meeting/projectmeeting";
    }
}
