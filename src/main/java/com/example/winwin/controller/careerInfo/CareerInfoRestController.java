package com.example.winwin.controller.careerInfo;

import com.example.winwin.dto.mentor.CareerInfoVo;
import com.example.winwin.service.career.CareerInfoService;
import com.example.winwin.vo.infinityScroll.Criteria;
import com.example.winwin.vo.infinityScroll.PageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/careerInfo/*")
public class CareerInfoRestController {

    private final CareerInfoService careerInfoService;

//    진로정보 글 전체 좋아요순 및 카테고리 별 조회하기
    @GetMapping("/list/{page}")
    public Map<String, Object> findCareerInfoList(@RequestParam(value = "tagList", required = false) List<Integer> tagList, HttpServletRequest req,
                                                 @PathVariable("page") int page){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria(page, 9);
        PageVo pageVo = new PageVo(criteria, careerInfoService.findCareerTotal());
        List<CareerInfoVo> careerInfoList = careerInfoService.findCareerInfoList(tagList, criteria);

//        VO, 커리어 리스트 둘 다 담아서 put
        Map<String, Object> carrerMap = new HashMap<>();
        carrerMap.put("pageVo", page);
        carrerMap.put("careerInfoList", careerInfoList);

        return carrerMap;
    }

}
