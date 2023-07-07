package com.example.winwin.controller.meeting;

import com.example.winwin.service.board.StudyService;
import com.example.winwin.vo.board.StudyVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes/*")
public class projectLikeController {
    private final StudyService studyService;

    @PostMapping("/{studyNumber}")
    public void likeRegister(@PathVariable("studyNumber") Long studyNumber, HttpServletRequest req){
        studyService.likeProcess((Long) req.getSession().getAttribute("userNumber"), studyNumber);
    }

    @GetMapping("/{studyNumber}")
    public int getLikeCnt(@PathVariable("studyNumber") Long studyNumber, HttpServletRequest req){
        return studyService.findLikeCnt((Long) req.getSession().getAttribute("userNumber"), studyNumber);
    }

}
