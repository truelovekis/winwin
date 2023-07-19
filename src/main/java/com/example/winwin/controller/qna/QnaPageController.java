package com.example.winwin.controller.qna;

import com.example.winwin.service.qna.QnaService;
import com.example.winwin.vo.board.QnaVo;
import com.example.winwin.vo.infinityScroll.Criteria;
import com.example.winwin.vo.infinityScroll.PageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qnaPage/*")
public class QnaPageController {
    private final QnaService qnaService;

    //  qna 글 무한 스크롤
    @GetMapping("/list/{page}")
    public Map<String, Object> qnaListPage(@PathVariable("page") int page){
        Criteria criteria = new Criteria();
        QnaVo qnaPageVo = new QnaVo();
        List<QnaVo> qnaVoList = qnaService.findListPage(qnaPageVo);

        qnaPageVo.setPage(page);
        PageVo pageVo = new PageVo(criteria, qnaService.findTotal());


        System.out.println("========================"+qnaVoList+"==========================");


        Map<String, Object> qnaMap = new HashMap<>();
        qnaMap.put("pageVo", pageVo);
        qnaMap.put("qnaList", qnaVoList);

        return qnaMap;
    }

    @GetMapping("/list2/{page}")
    public Map<String, Object> getList(@PathVariable("page") int page, @RequestParam(value = "cateList", required = false) List<Integer> cateList){
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        int total = qnaService.findTotal();
        PageVo pageVo = new PageVo(criteria, total);
        List<QnaVo> qnaVoList =qnaService.findQnaList(criteria,cateList);
        if(qnaVoList.size() > 0){
            for (QnaVo qnaVo: qnaVoList) {

                // reg_date를 LocalDateTime으로 변환
                LocalDateTime qnaDate = LocalDateTime.parse(qnaVo.getQnaDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                // 현재 시간과의 차이 계산
                long minutesDiff = ChronoUnit.MINUTES.between(qnaDate, LocalDateTime.now());
                long hoursDiff = ChronoUnit.HOURS.between(qnaDate, LocalDateTime.now());
                long daysDiff = ChronoUnit.DAYS.between(qnaDate, LocalDateTime.now());

                // 경과 시간 표시
                if (minutesDiff < 60) {
                    qnaVo.setQnaDate(minutesDiff + "분 전");
                } else if (hoursDiff < 24) {
                    qnaVo.setQnaDate(hoursDiff + "시간 전");
                } else if (daysDiff < 365) {
                    qnaVo.setQnaDate(daysDiff + "일 전");
                }
            }
        }


        Map<String, Object> map = new HashMap<>();
        map.put("qnaList", qnaVoList);
        map.put("pageVo", pageVo);

        return map;
    }
}
