package com.example.winwin.controller.careerInfo;

import com.example.winwin.dto.careerInfo.CareerInfoLikeDto;
import com.example.winwin.service.career.CareerInfoCommentService;
import com.example.winwin.service.career.CareerInfoLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/careerInfoLike/*")
public class CareerInfoLikeRestController {

    private final CareerInfoLikeService careerInfoLikeService;

//    진로정보 글 좋아요 등록
    @PostMapping("/likeBtn")
    public int careerInfoLikeRegister(CareerInfoLikeDto careerInfoLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        careerInfoLikeDto.setUserNumber(userNumber);

        System.out.println(careerInfoLikeDto);

        return careerInfoLikeService.careerInfoLikeProcess(careerInfoLikeDto);

    }

//    유저가 좋아요 한 진로정보 글 찾기
    @GetMapping("/likeCnt")
    public void careerInfoLikeCnt(@RequestBody CareerInfoLikeDto careerInfoLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        careerInfoLikeDto.setUserNumber(userNumber);

        careerInfoLikeService.findCareerInfoUser(careerInfoLikeDto);
    }

//    진로정보 글 좋아요 취소
    @DeleteMapping("/likeCancle")
    public void careerInfoLikeRemove(@RequestBody CareerInfoLikeDto careerInfoLikeDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        careerInfoLikeDto.setUserNumber(userNumber);

        careerInfoLikeService.removeCareerInfoLike(careerInfoLikeDto);
    }
}
