package com.example.winwin.controller.qna;

import com.example.winwin.service.qna.QnaCommentUdService;
import com.example.winwin.vo.board.QnaCommentUdVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qnaUds/*")
public class QnaCommentUdController {
    private final QnaCommentUdService qnaCommentUdService;

    @PostMapping("/goodUp")
    public void goodInsert(@RequestBody QnaCommentUdVo qnaCommentUdVo, HttpServletRequest req) {
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        System.out.println("댓글 레스트 컨트롤러 좋아요UP 연결 성공!!!!!!!!!!!!");
        qnaCommentUdVo.setUserNumber(userNumber);
        qnaCommentUdVo.setUdStatus("u");
        if( qnaCommentUdService.qnaUdFind(qnaCommentUdVo) > 0){
            qnaCommentUdService.qnaHateCancle(qnaCommentUdVo);
        }

        qnaCommentUdService.qnaGoodInsert(qnaCommentUdVo);

    }

    @DeleteMapping("/goodDown")
    public void goodCancle(@RequestBody QnaCommentUdVo qnaCommentUdVo, HttpServletRequest req) {
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        System.out.println("댓글 좋아요, 싫어요DOWN 연결 성공!!!!!!!!!!!!!!!!");
        qnaCommentUdVo.setUserNumber(userNumber);
        qnaCommentUdService.qnaGoodCancle(qnaCommentUdVo);
    }

    @PostMapping("/hateUp")
    public void hateInsert(@RequestBody QnaCommentUdVo qnaCommentUdVo, HttpServletRequest req) {
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        System.out.println("댓글 레스트 컨트롤러 싫어요 UP 연결 성공!!!!!!!!!!!!");
        qnaCommentUdVo.setUserNumber(userNumber);
        qnaCommentUdVo.setUdStatus("d");
        if( qnaCommentUdService.qnaUdFind(qnaCommentUdVo) > 0){
            qnaCommentUdService.qnaGoodCancle(qnaCommentUdVo);
        }
        qnaCommentUdService.qnaHateInsert(qnaCommentUdVo);

    }

    @DeleteMapping("/hateDown")
    public void hateCancle(@RequestBody QnaCommentUdVo qnaCommentUdVo, HttpServletRequest req) {
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        System.out.println("댓글 싫어요 DOWN 연결 성공!!!!!!!!!!!!!!!!");
        qnaCommentUdVo.setUserNumber(userNumber);
        qnaCommentUdService.qnaHateCancle(qnaCommentUdVo);
    }
}