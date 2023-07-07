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
import java.util.List;

@Controller
@RequestMapping("/project/*")
@RequiredArgsConstructor
public class projectController {

    private final StudyService studyService;

    @GetMapping("/read")
    public String projectRead(Long studyNumber, Model model) {
        studyService.readUpdate(studyNumber);
        StudyVo studyVo = studyService.studyFind(studyNumber);
        List<StudyVo> otherList = studyService.findOtherList(studyVo.getCategoryNumber());
        model.addAttribute("studyVo", studyVo);
        model.addAttribute("otherList", otherList);
        return "/project/projectRead";
    }

    @GetMapping("/modify")
    public String update2(Long studyNumber, Model model) {
        StudyVo studyVo = studyService.studyFind(studyNumber);
        model.addAttribute("studyVo", studyVo);
        return "/project/projectModify";
    }

    @PostMapping("/modify")
    public RedirectView update(StudyVo studyVo, RedirectAttributes redirectAttributes) {
        studyService.studyModify(studyVo);
        redirectAttributes.addAttribute("studyNumber", studyVo.getStudyNumber());
        return new RedirectView("/meeting/home");
    }

    @GetMapping("/delete")
    public RedirectView delete(Long studyNumber) {
        studyService.studyLikeRemove(studyNumber);
        studyService.studyRemove(studyNumber);
        return new RedirectView("/meeting/home");
    }


    @GetMapping("/write")
    public String projectWrite() {
        return "/project/projectWrite";
    }


    @PostMapping("/write")
    public RedirectView write(StudyDto studyDto, HttpServletRequest req) {

        Long userNumber = (Long) req.getSession().getAttribute("userNumber");

        studyDto.setUserNumber(userNumber);

        studyService.studyRegister(studyDto);
        System.out.println("==========123123==========");


        return new RedirectView("/meeting/home");
    }
}
