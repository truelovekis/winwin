package com.example.winwin.controller.police;

import com.example.winwin.dto.police.PoliceBoardDto;
import com.example.winwin.service.police.PoliceService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/police")
public class SharePoliceRestController {

    private final PoliceService policeService;

//    나눔 페이지 bigcode 600 고정
//
//    나눔 글 신고하기
    @PostMapping("/share")
    public void shareReport(@RequestBody PoliceBoardDto policeBoardDto){
//        로그인 세션 처리
        policeBoardDto.setUserNumber(8L);
//      ------------------------------------
        policeBoardDto.setBigCode("600");
        policeService.policeBoardRegister(policeBoardDto);

    }
}
