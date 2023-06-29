package com.example.winwin.controller.project;

import com.example.winwin.service.board.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projectStudy/*")
@RequiredArgsConstructor
public class projectStudyController {

    private final StudyService studyService;

 
    }
}
