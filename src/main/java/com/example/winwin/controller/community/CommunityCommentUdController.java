package com.example.winwin.controller.community;

import com.example.winwin.service.board.CommunityCommentUdService;
import com.example.winwin.vo.board.CommunityCommentUdVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/uds/*")
public class CommunityCommentUdController {
    private final CommunityCommentUdService communityCommentUdService;

    @PostMapping("/goodUp")
    public void goodInsert(@RequestBody CommunityCommentUdVo communityCommentUdVo, HttpServletRequest req) {
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        System.out.println("댓글 레스트 컨트롤러 좋아요UP 연결 성공!!!!!!!!!!!!");
        communityCommentUdVo.setUserNumber(userNumber);
        communityCommentUdVo.setUdStatus("u");
        if( communityCommentUdService.udFind(communityCommentUdVo) > 0){
            communityCommentUdService.hateCancle(communityCommentUdVo);
        }

        communityCommentUdService.goodInsert(communityCommentUdVo);

    }

    @DeleteMapping("/goodDown")
    public void goodCancle(@RequestBody CommunityCommentUdVo communityCommentUdVo, HttpServletRequest req) {
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        System.out.println("댓글 좋아요, 싫어요DOWN 연결 성공!!!!!!!!!!!!!!!!");
        communityCommentUdVo.setUserNumber(userNumber);
        communityCommentUdService.goodCancle(communityCommentUdVo);
    }

    @PostMapping("/hateUp")
    public void hateInsert(@RequestBody CommunityCommentUdVo communityCommentUdVo, HttpServletRequest req) {
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        System.out.println("댓글 레스트 컨트롤러 싫어요 UP 연결 성공!!!!!!!!!!!!");
        communityCommentUdVo.setUserNumber(userNumber);
        communityCommentUdVo.setUdStatus("d");
        if( communityCommentUdService.udFind(communityCommentUdVo) > 0){
            communityCommentUdService.goodCancle(communityCommentUdVo);
        }

        communityCommentUdService.hateInsert(communityCommentUdVo);

    }

    @DeleteMapping("/hateDown")
    public void hateCancle(@RequestBody CommunityCommentUdVo communityCommentUdVo, HttpServletRequest req) {
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        System.out.println("댓글 싫어요 DOWN 연결 성공!!!!!!!!!!!!!!!!");
        communityCommentUdVo.setUserNumber(userNumber);
        communityCommentUdService.hateCancle(communityCommentUdVo);
    }

}
