package com.example.winwin.controller.community;


import com.example.winwin.service.board.CommunityService;
import com.example.winwin.vo.board.CommunityVo;
import com.example.winwin.vo.infinityScroll.Criteria;
import com.example.winwin.vo.infinityScroll.PageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/communityScroll/*")
public class CommunityRestController {
    private final CommunityService communityService;

    //  나눔 글 무한 스크롤
    @GetMapping("/list/{categoryTypeStr}/{page}")
    public Map<String, Object> communityListPage(@PathVariable("page") int page,
                 @PathVariable("categoryTypeStr") String categoryTypeStr){
        Criteria criteria = new Criteria();
        CommunityVo paramCommunityVo = new CommunityVo();
        paramCommunityVo.setCategoryTypeStr(categoryTypeStr);
        if(! "all".equals(categoryTypeStr)){
            paramCommunityVo.setCategoryNumber(Long.parseLong(categoryTypeStr));
        }

        paramCommunityVo.setPage(page);
        PageVo pageVo = new PageVo(criteria, communityService.findTotal());

        List<CommunityVo> communityVoList = communityService.findListPage(paramCommunityVo);

        System.out.println("========================"+communityVoList+"==========================");


        if(communityVoList.size() > 0){
            for (CommunityVo communityVo: communityVoList) {

                // reg_date를 LocalDateTime으로 변환
                LocalDateTime communityDate = LocalDateTime.parse(communityVo.getCommunityDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                // 현재 시간과의 차이 계산
                long minutesDiff = ChronoUnit.MINUTES.between(communityDate, LocalDateTime.now());
                long hoursDiff = ChronoUnit.HOURS.between(communityDate, LocalDateTime.now());
                long daysDiff = ChronoUnit.DAYS.between(communityDate, LocalDateTime.now());

                // 경과 시간 표시
                if (minutesDiff < 60) {
                    communityVo.setCommunityDate(minutesDiff + "분 전");
                } else if (hoursDiff < 24) {
                    communityVo.setCommunityDate(hoursDiff + "시간 전");
                } else if (daysDiff < 365) {
                    communityVo.setCommunityDate(daysDiff + "일 전");
                }
            }
        }
        Map<String, Object> communityMap = new HashMap<>();
        communityMap.put("pageVo", pageVo);
        communityMap.put("categoryTypeStr", categoryTypeStr);
        communityMap.put("communityList", communityVoList);

        return communityMap;
    }
}
