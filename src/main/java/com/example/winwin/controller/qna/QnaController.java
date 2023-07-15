package com.example.winwin.controller.qna;

import com.example.winwin.dto.board.QnaDto;
import com.example.winwin.dto.board.QnaGoodDto;
import com.example.winwin.dto.board.QsBridgeDto;
import com.example.winwin.service.qna.QnaCommentService;
import com.example.winwin.service.qna.QnaCommentUdService;
import com.example.winwin.service.qna.QnaGoodService;
import com.example.winwin.service.qna.QnaService;
import com.example.winwin.vo.board.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/qna/*")
@RequiredArgsConstructor
public class QnaController {

    private final QnaService qnaService;
    private final QnaGoodService qnaGoodService;
    private final QnaCommentService qnaCommentService;
    private final QnaCommentUdService qnaCommentUdService;

    @GetMapping("/read")
    public String qnaRead(Long qnaNumber, Model model, HttpServletRequest req){

        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        QnaVo qnaVo = qnaService.findQna(qnaNumber);

//        Long sessionUserNumber = (Long)req.getSession().getAttribute("userNumber");
        QnaCommentVo qnaCommentVo = new QnaCommentVo();
        qnaCommentVo.setSessionUserNumber(userNumber);
        qnaCommentVo.setQnaNumber(qnaNumber);
        System.out.println("111111111");
        List<QnaCommentVo> qnaCommentVoList = qnaCommentService.findQnaCommentUdList(qnaCommentVo);
        qnaService.upQnaCnt(qnaNumber);
        qnaVo.setUserNumber(userNumber);

        System.out.println("222222222");
        qnaVo.setQnaNumber(qnaNumber);


        System.out.println("=========================");
        System.out.println(qnaNumber);
        System.out.println("========================");
        System.out.println(qnaVo + "==========================");



        int commentCnt = qnaService.commentCnt(qnaNumber);
        QnaGoodDto qnaGoodDto = new QnaGoodDto();
        qnaGoodDto.setQnaNumber(qnaNumber);
        qnaGoodDto.setUserNumber(userNumber);
        Long likeStatus = qnaGoodService.findQnaLike(qnaGoodDto);
        int qnaLikeCnt = qnaGoodService.likeQnaCnt(qnaGoodDto);
        System.out.println("333333333");
        model.addAttribute("qna", qnaVo);
        model.addAttribute("likeStatus", likeStatus);
        model.addAttribute("qnaLikeCnt", qnaLikeCnt);
        model.addAttribute("commentCnt", commentCnt);
        model.addAttribute("commentList", qnaCommentVoList);
        System.out.println("4444444444");
        System.out.println(qnaVo+"==============");

        return "/qna/qnaRead";
    }

    @GetMapping("/write")
    public String qnaWrite(HttpServletRequest req, Model model){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
//        QnaVo qnaVo = qnaService.findQna(qnaNumber);
//        model.addAttribute("qna", qnaVo);
        return userNumber == null? "/user/loginModal " : "/qna/qnaWrite";
    }


    @PostMapping("/write")
    public RedirectView qnaWriteOk(QnaDto qnaDto, @RequestParam("subList")List<Long> subList, HttpServletRequest req, RedirectAttributes redirectAttributes){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        qnaDto.setUserNumber(userNumber);
        qnaService.registerQna(qnaDto);
        System.out.println("=========="+qnaDto);
        QsBridgeDto qsBridgeDto = new QsBridgeDto();

        for(Long subNum : subList){
            qsBridgeDto.setQnaNumber(qnaDto.getQnaNumber());
            qsBridgeDto.setSubNumber(subNum);
            qnaService.registerQs(qsBridgeDto);
        }
        redirectAttributes.addFlashAttribute("qnaNumber", qnaDto.getQnaNumber());
        return new RedirectView("/qna/list");
    }

    @GetMapping("/list")
    public String qnaList(Model model, HttpServletRequest req) {
//        List<QnaVo> qnaList = qnaService.findQnaList();
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        // 카테고리 리스트
//        Map<Long, List<QnaVo>> subLists = new HashMap<>();
//
//        for (QnaVo qna : qnaList) {
//            Long qnaNumber = qna.getQnaNumber();
//            List<QnaVo> subList = qnaService.findSubList(qnaNumber);
//            subLists.put(qnaNumber, subList);
//        }

        List<QnaProfileVo> qnaProfileVoList = qnaService.registerProfile(userNumber);

//        System.out.println("==================================="+qnaList);
//        if(qnaList.size() > 0){
//            for (QnaVo qnaVo: qnaList) {
//
//                // reg_date를 LocalDateTime으로 변환
//                LocalDateTime qnaDate = LocalDateTime.parse(qnaVo.getQnaDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//
//                // 현재 시간과의 차이 계산
//                long minutesDiff = ChronoUnit.MINUTES.between(qnaDate, LocalDateTime.now());
//                long hoursDiff = ChronoUnit.HOURS.between(qnaDate, LocalDateTime.now());
//                long daysDiff = ChronoUnit.DAYS.between(qnaDate, LocalDateTime.now());
//
//                // 경과 시간 표시
//                if (minutesDiff < 60) {
//                    qnaVo.setQnaDate(minutesDiff + "분 전");
//                } else if (hoursDiff < 24) {
//                    qnaVo.setQnaDate(hoursDiff + "시간 전");
//                } else if (daysDiff < 365) {
//                    qnaVo.setQnaDate(daysDiff + "일 전");
//                }
//            }
//        }

//        model.addAttribute("qnaList", qnaList);
        model.addAttribute("qnaProfile", qnaProfileVoList);
//        model.addAttribute("subLists", subLists);
        return "/qna/qna";
    }

    // 삭제
    @GetMapping("/removeQna")
    public RedirectView removeQna(Long qnaNumber, RedirectAttributes redirectAttributes){

        qnaService.removeQs(qnaNumber);
//        qnaCommentService.remove(commentNumber);
        qnaService.removeQna(qnaNumber);
        return new RedirectView("/qna/list");
    }

    // 수정
    @GetMapping("/modify")
    public String modifyQna(Long qnaNumber, Model model){
        QnaVo qnaVo = qnaService.findQna(qnaNumber);
        model.addAttribute("qna", qnaVo);
        return "qna/qnaModify";
    }

    @PostMapping("/modify")
    public RedirectView modify(QnaVo qnaVo, QsBridgeDto qsBridgeDto, RedirectAttributes redirectAttributes){
            qnaService.modifyQs(qsBridgeDto);
            qnaService.modifyQna(qnaVo);

        redirectAttributes.addAttribute("qnaNumber", qnaVo.getQnaNumber());
        return new RedirectView("/qna/read");
    }


}