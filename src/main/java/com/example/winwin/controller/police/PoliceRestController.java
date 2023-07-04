package com.example.winwin.controller.police;

import com.example.winwin.dto.police.PoliceBoardDto;
import com.example.winwin.dto.police.PoliceCommentDto;
import com.example.winwin.service.police.PoliceService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/police")
public class PoliceRestController {

    private final PoliceService policeService;

    //    나눔 페이지 bigcode 600 고정
//
//    나눔 글 신고하기
    @PostMapping("/share")
    public void shareReport(@RequestBody PoliceBoardDto policeBoardDto) {
//        로그인 세션 처리
        policeBoardDto.setUserNumber(8L);
//      ------------------------------------
        policeBoardDto.setBigCode("600");
        policeService.policeBoardRegister(policeBoardDto);

    }

    @PostMapping("/community")
    public void communityReport(@RequestBody PoliceBoardDto policeBoardDto, HttpServletRequest req) {
//        로그인 세션 처리
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
//      ------------------------------------
        policeBoardDto.setBigCode("400");
        policeBoardDto.setUserNumber(userNumber);
        policeService.policeBoardRegister(policeBoardDto);
    }

    @PostMapping("/comment")
    public void communityCommentReport(@RequestBody PoliceCommentDto policeCommentDto, HttpServletRequest req) {
//        로그인 세션 처리
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
//      ------------------------------------
        policeCommentDto.setBigCode("400");
        policeCommentDto.setUserNumber(userNumber);
        System.out.println("==============================");
        System.out.println(policeCommentDto);
        policeService.policeCommentRegister(policeCommentDto);
        System.out.println("==============================");
        System.out.println(policeCommentDto);
    }


}
