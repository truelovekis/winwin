package com.example.winwin.controller.mentor;

import com.example.winwin.dto.careerInfo.CareerInfoDto;
import com.example.winwin.dto.mentor.CareerInfoVo;
import com.example.winwin.service.career.CareerInfoService;
import com.example.winwin.service.mentor.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/career/*")
public class CareerInfoController {
    private final MentorService mentorService;

    @GetMapping("/info")
    public List<CareerInfoVo> infoList(Long mentorNumber, Model model){
        int careerInfoLike = mentorService.careerInfoLike(mentorNumber);
        model.addAttribute("likeCnt", careerInfoLike);
        return mentorService.infoList(mentorNumber);
    }

}

