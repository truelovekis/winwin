package com.example.winwin.controller.mentor;

import com.example.winwin.dto.mentor.*;
import com.example.winwin.service.mentor.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mentor/*")
public class MentorController {
    private final MentorService mentorService;

//    멘토:멘티 리스트 페이지 처리
    @GetMapping("/list")
    public String mentorList(Model model, Long mentorNumber, MentorVo mentorVo){
        List<MentorVo> mentorList = mentorService.findList();
        model.addAttribute("mentorList", mentorList);

        MentorVo loginMentor = mentorService.findLoginMentor(6L, mentorVo);
        model.addAttribute("loginMentor", loginMentor);

        List<SkillVo> skill = mentorService.profileSkill(6L);
        model.addAttribute("skill", skill);

        List<CareerVo> career = mentorService.profileCareer(6L);
        model.addAttribute("career" , career);

        return "mentor/mentorProfile";
    }

    @PostMapping("/list")
    public RedirectView mentorModify(MentorVo mentorVo, RedirectAttributes redirectAttributes){
        mentorService.modifyMentor(mentorVo);
        redirectAttributes.addFlashAttribute("mentorNumber",mentorVo.getMentorNumber());

        return new RedirectView("/mentor/list");
    }

//    멘토:멘티 멘토 개인 프로필 처리
    @GetMapping("/profile")
    public String profile(Model model, Long mentorNumber){
        MentorVo mentorVo = mentorService.findProfile(mentorNumber);
        model.addAttribute("profile", mentorVo);

        List<SkillVo> skill = mentorService.profileSkill(mentorNumber);
        model.addAttribute("skill", skill);

        List<CareerVo> career = mentorService.profileCareer(mentorNumber);
        model.addAttribute("career" , career);

        MentorVo mentorAvg = mentorService.findReview(mentorNumber);
        model.addAttribute("review", mentorAvg);

        List<CategoryVo> categoryList = mentorService.findCategoryList();
        model.addAttribute("categoryList", categoryList);

        return "mentor/DefaultProfile";
    }

//    멘토 프로필 등록하기 처리
    @GetMapping("/apply")
    public String apply(Long mentorNumber, Model model){
        MentorVo mentor = mentorService.findMentor(6L);
        List<MentorVo> mentor2 = mentorService.findMentor2(6L);
        List<CareerVo> careerList = mentorService.findCareerList(6L);
        model.addAttribute("careerList", careerList);

        List<SkillVo> skill = mentorService.findSkill(6L);
        model.addAttribute("skill", skill);

        model.addAttribute("mentor", mentor);
        model.addAttribute("mentor2" , mentor2);
        return "mentor/Apply";
    }

    @PostMapping("/apply")
    public RedirectView apply(MentorVo mentorVo, HttpServletRequest req, RedirectAttributes redirectAttributes){


        return new RedirectView("/mentor/apply");
    }

    //    멘토 프로필 등록하기 기본 페이지 처리
    @GetMapping("/self")
    public String self(Long mentorNumber, Model model){
        MentorVo mentor = mentorService.findMentor(6L);

        model.addAttribute("mentor", mentor);
        return "mentor/Introduceyourself";
    }

    @PostMapping("/self")
    public RedirectView self(MentorVo mentorVo, HttpServletRequest req, RedirectAttributes redirectAttributes){
        Long userNumber = (Long) req.getSession().getAttribute("mentorNumber");
        mentorVo.setMentorNumber(6L);
        mentorVo.setUserNumber(6L);
        mentorService.mentorPrRegister(mentorVo);

        return new RedirectView("/mentor/apply");
    }

    //    멘토 프로필 등록하기 경력 처리
    @GetMapping("/career")
    public String careerUpdate(){

        return "mentor/specUpdate";
    }

    @PostMapping("/career")
    public RedirectView careerUpdate(CareerVo careerVo, HttpServletRequest req, RedirectAttributes redirectAttributes){
        Long mentorNumber = (Long) req.getSession().getAttribute("mentorNumber");
        careerVo.setMentorNumber(mentorNumber);

//        mentorService.careerModify(mentorNumber,careerVo);
        mentorService.careerRegister(6L,careerVo);

        return new RedirectView("/mentor/apply");
    }

//    멘토 프로필 등록하기 스킬 처리
    @GetMapping("/skill")
    public String defaultProfile(Model model, Long mentorNumber){
        List<SkillVo> skill = mentorService.findSkill(mentorNumber);
        model.addAttribute("skill", skill);

        return "mentor/skillUpdate";
    }

    @PostMapping("/skill")
    public RedirectView skillUpdate(@RequestParam("skillName") List<String> skillList , HttpServletRequest req, RedirectAttributes redirectAttributes){
        Long mentorNumber = (Long) req.getSession().getAttribute("mentorNumber");
        mentorService.skillRemoveAndRegister(mentorNumber, skillList);
//        mentorService.skillRemoveAndRegister(6L, skillList);

        return new RedirectView("/mentor/apply");
    }


}
