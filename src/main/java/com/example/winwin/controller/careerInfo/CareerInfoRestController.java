package com.example.winwin.controller.careerInfo;

import com.example.winwin.dto.mentor.CareerInfoVo;
import com.example.winwin.service.career.CareerInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/careerInfo")
public class CareerInfoRestController {

    private final CareerInfoService careerInfoService;

//    진로정보 글 전체 좋아요순 및 카테고리 별 조회하기
    @GetMapping("/list")
    public List<CareerInfoVo> findCareerInfoList(@RequestParam(value = "tagList") List<Integer> tagList, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        return careerInfoService.findCareerInfoList(tagList);
    }

//    진로정보 글 무한스크롤

}
