package com.example.winwin.controller.mentor;

import com.example.winwin.dto.mentor.*;
import com.example.winwin.dto.user.UserPfpDto;
import com.example.winwin.service.mentor.MentorService;
import com.example.winwin.service.myPage.MyPageService;
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
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mentor/*")
public class MentorController {
    private final MentorService mentorService;
    private final MyPageService myPageService;

//    멘토:멘티 리스트 페이지 처리
    @GetMapping("/list")
    public String mentorList(Model model, MentorVo mentorVo, HttpServletRequest req, @RequestParam(value = "subNumber", required = false) List<Integer> subList){

        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        List<MentorVo> mentorList = mentorService.findList(userNumber==null? 0 : userNumber, subList);
        model.addAttribute("mentorList", mentorList);

        Long mentorNumber = (Long)req.getSession().getAttribute("mentorNumber");
        MentorVo loginMentor = mentorService.findLoginMentor(mentorNumber==null?0:mentorNumber);
        model.addAttribute("loginMentor", loginMentor);

        List<SkillVo> skill = mentorService.profileSkill(mentorNumber==null?0:mentorNumber);
        model.addAttribute("skill", skill);

        List<CareerVo> career = mentorService.profileCareer(mentorNumber==null?0:mentorNumber);
        model.addAttribute("career" , career);

        return "mentor/mentorProfile";
    }

//    멘토:멘티 멘토 개인 프로필 처리
    @GetMapping("/profile")
    public String profile(Model model, Long mentorNumber, HttpServletRequest req){
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        MentorVo mentorVo = mentorService.findProfile(mentorNumber, userNumber == null? 0 : userNumber);
        model.addAttribute("profile2", mentorVo);

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
    public String apply(Model model, HttpServletRequest req){

        Long mentorNumber = (Long) req.getSession().getAttribute("mentorNumber");
        MentorVo mentor = mentorService.findMentor(mentorNumber);
        List<MentorVo> mentor2 = mentorService.findMentor2(mentorNumber);
        List<CareerVo> careerList = mentorService.findCareerList(mentorNumber);
        model.addAttribute("careerList", careerList);

        List<SkillVo> skill = mentorService.findSkill(mentorNumber);
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
        MentorVo mentor = mentorService.findMentor(mentorNumber);

        model.addAttribute("mentor", mentor);
        return "mentor/Introduceyourself";
    }

    @PostMapping("/self")
    public RedirectView self(MentorVo mentorVo, HttpServletRequest req, RedirectAttributes redirectAttributes){
        Long mentorNumber = (Long) req.getSession().getAttribute("mentorNumber");
        mentorVo.setMentorNumber(mentorNumber);
        mentorVo.setUserNumber(mentorNumber);
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
        mentorService.careerRegister(mentorNumber,careerVo);

        return new RedirectView("/mentor/apply");
    }

//    멘토 프로필 등록하기 스킬 처리
    @GetMapping("/skill")
    public String defaultProfile(Model model,HttpServletRequest req){
        Long mentorNumber = (Long) req.getSession().getAttribute("mentorNumber");
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
