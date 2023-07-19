
package com.example.winwin.controller.cs;

import com.example.winwin.service.cs.CsService;
import com.example.winwin.vo.board.CsVo;
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
@RequestMapping("/csScroll/*")
public class CsRestController {
    private final CsService csService;

    //  문의사항 글 무한 스크롤
    @GetMapping("/list/{page}")
    public Map<String, Object> csListPage(@PathVariable("page") int page){
        Criteria criteria = new Criteria();
        CsVo paramCsVo = new CsVo();
        paramCsVo.setPage(page);
        PageVo pageVo = new PageVo(criteria, csService.findTotal());

        List<CsVo> csVoList = csService.findListPage(paramCsVo);

        if(csVoList.size() > 0){
            for (CsVo csVo: csVoList) {

                // reg_date를 LocalDateTime으로 변환
                LocalDateTime csDate = LocalDateTime.parse(csVo.getCsDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                // 현재 시간과의 차이 계산
                long minutesDiff = ChronoUnit.MINUTES.between(csDate, LocalDateTime.now());
                long hoursDiff = ChronoUnit.HOURS.between(csDate, LocalDateTime.now());
                long daysDiff = ChronoUnit.DAYS.between(csDate, LocalDateTime.now());

                // 경과 시간 표시
                if (minutesDiff < 60) {
                    csVo.setCsDate(minutesDiff + "분 전");
                } else if (hoursDiff < 24) {
                    csVo.setCsDate(hoursDiff + "시간 전");
                } else if (daysDiff < 365) {
                    csVo.setCsDate(daysDiff + "일 전");
                }
            }
        }
        Map<String, Object> csMap = new HashMap<>();
        csMap.put("pageVo", pageVo);
        csMap.put("csVoList", csVoList);

        return csMap;
    }
}
