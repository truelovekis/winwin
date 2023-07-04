package com.example.winwin.controller.cs;

import com.example.winwin.dto.board.CsCommentDto;
import com.example.winwin.service.cs.CsReplayService;
import com.example.winwin.vo.board.CommunityVo;
import com.example.winwin.vo.board.CsReplayVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
    @RequiredArgsConstructor
    @RequestMapping("/Replies/*")
    public class CsReplyController {
        private final CsReplayService csReplyService;

        @PostMapping("/Reply")
        public String ReplyRegister(@RequestBody CsCommentDto csCommentDto, HttpServletRequest req){
            Long userNumber = (Long)req.getSession().getAttribute("userNumber");
             csCommentDto.setUserNumber(userNumber);
            System.out.println(csCommentDto);
            csReplyService.register(csCommentDto);
            return "작성 성공!";
        }

        @GetMapping("/list{csNumber}")
        public List<CsReplayVo> getCommentList(@PathVariable("csNumber") Long csNumber){
           return csReplyService.findList(csNumber);
        }


        @PatchMapping("/{commentNumber}")
        public void commentModify(@PathVariable("commentNumber") Long commentNumber, @RequestBody CsCommentDto csCommentDto){
            csCommentDto.setCommentNumber(commentNumber);
            csReplyService.modify(csCommentDto);
        }

        @GetMapping("/{commentNumber}")
        public CsReplayVo commentView(@PathVariable("commentNumber") Long commentNumber){
            return csReplyService.findComment(commentNumber);
        }

        @DeleteMapping("/{commentNumber}")
        public void commentRemove(@PathVariable("commentNumber") Long commentNumber){
           csReplyService.remove(commentNumber);
        }

    }