package com.example.winwin.controller.careerInfo;

import com.example.winwin.service.career.CareerInfoCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/careerInfoLike/*")
public class CareerInfoLikeRestController {

    private final CareerInfoCommentService careerInfoCommentService;

//    진로정보 글 좋아요 등록
    @PostMapping("/likeBtn")
    public void careerInfoLikeRegister(){

    }

//    진로정보 글 좋아요 카운트

//    유저가 좋아요 한 진로정보 글 찾기

//    진로정보 글 좋아요 취소
}
