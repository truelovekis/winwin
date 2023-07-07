package com.example.winwin.controller.careerInfo;

import com.example.winwin.dto.careerInfo.CareerInfoDto;
import com.example.winwin.dto.mentor.CareerInfoVo;
import com.example.winwin.dto.mentor.CategoryVo;
import com.example.winwin.service.career.CareerInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/career/*")
public class CareerContoller {

    private final CareerInfoService careerInfoService;

//    세션으로 userNumber가져와서 페이지 진입할 때, 태그에 대한 리스트 뿌려줘
//    진로정보 메인페이지 단순이동
    @GetMapping("/list")
    public String careerpathForm(Model model, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        List<CategoryVo> userTagList = careerInfoService.findMentorTag(userNumber);
        model.addAttribute("userTagList", userTagList);
//        List<CareerInfoDto> careerInfoList = careerInfoService.

        return "careerInfo/careerInfo";
    }

//    진로정보 페이지 상세페이지 단순이동
    @GetMapping("/detail")
    public String careerDetail(Long careerInfoNumber, Model model){
        careerInfoService.careerInfoReadUpdate(careerInfoNumber);
        CareerInfoDto careerInfoDto = careerInfoService.findCareerInfo(careerInfoNumber);
        model.addAttribute("career", careerInfoDto);

        return "careerInfo/careerInfoDetail";
    }

//    진로정보 글 작성하기 페이지 단순이동
    @GetMapping("/write")
    public String careerWrite (HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

        return "careerInfo/careerInfoWrite";
    }

    @PostMapping("/write")
    public RedirectView careerWrite(CareerInfoVo careerInfoVo, HttpServletRequest req){

        return null;
    }

//    진로정보 글 수정하기 단순이동
    @GetMapping("/modify")
    public String careerModify(Long careerInfoNumber, Model model){
        CareerInfoDto careerInfoDto = careerInfoService.findCareerInfo(careerInfoNumber);
        model.addAttribute("career", careerInfoDto);

        return "careerInfo/careerInfoModify";
    }

//    진로정보 글 삭제하기

//    진로정보 글 신고하기

}
