package com.example.winwin.controller.cs;


import com.example.winwin.dto.board.CsDto;
import com.example.winwin.service.cs.CsReplyService;
import com.example.winwin.service.cs.CsService;
import com.example.winwin.vo.board.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cs/*")
public class CsController {
    private final CsService csService;
    private final CsReplyService csReplyService;

    //    CS 메인페이지
    @GetMapping("/main")
    public String csMain(Model model, HttpServletRequest req) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        List<CsVo> csVoList = csService.findAll();
        model.addAttribute("csVoList", csVoList);

        // ↓ 유저프로필

        CsProfileVo csProfileVo = csService.findUser(userNumber == null? 0 : userNumber);
        model.addAttribute("userPfp" , csProfileVo);

        // ↑ 유저프로필

        List<CsProfileVo> csProfileVoList = csService.getProfile(userNumber);
        model.addAttribute("csProfileVoList", csProfileVoList);

        return "cs/csMain";
    }

    //    글 작성하기
    @GetMapping("/write")
    public String csWriteForm(HttpServletRequest req) {

        return "cs/csWrite";
    }

    @PostMapping("/write")
    public RedirectView csWrite(CsDto csDto, HttpServletRequest req) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        csDto.setUserNumber(userNumber);
        csService.register(csDto);

        return new RedirectView("/cs/main");
    }

    // 유저 프로필
    @GetMapping("/list/{categoryTypeStr}")
    public String csMainForm(@PathVariable("categoryTypeStr") String categoryTypeStr, Model model, HttpServletRequest req) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        List<CsProfileVo> csProfileVoList = csService.getProfile(userNumber);
        model.addAttribute("csProfileVoList", csProfileVoList);
        return "cs/csMain";
    }

    //    글 상세보기
    @GetMapping("/read")
    public String csRead(Long csNumber, Model model) {
        CsVo csVo = csService.findCs(csNumber);
        List<CsReplyVo> csReplyVoList = csReplyService.findList(csNumber);
        csService.upHitCnt(csNumber);
        int commentCnt = csService.commentCnt(csNumber);

        model.addAttribute("cs", csVo);
        model.addAttribute("commentCnt", commentCnt);
        System.out.println("===================================!!!!"+csVo);
        model.addAttribute("replyList", csReplyVoList);
        return "cs/csRead";

    }

    /* 수정*/
    @GetMapping("/modify")
    public String modifyForm(Long csNumber, Model model) {
        CsVo csVo = csService.findCs(csNumber);
        model.addAttribute("cs", csVo);
        return "cs/csModify";
    }

    @PostMapping("/modify")
    public RedirectView modify(CsDto csDto, RedirectAttributes redirectAttributes) {
        try {
            csService.modify(csDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        redirectAttributes.addAttribute("csNumber", csDto.getCsNumber());
        return new RedirectView("/cs/read");
    }

    @GetMapping("/remove")
    public RedirectView remove(Long csNumber, RedirectAttributes redirectAttributes) {
        csService.remove(csNumber);
        return new RedirectView("/cs/main");
    }





}

