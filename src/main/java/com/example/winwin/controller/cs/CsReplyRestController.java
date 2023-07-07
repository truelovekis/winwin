package com.example.winwin.controller.cs;

import com.example.winwin.dto.board.CsCommentDto;
import com.example.winwin.service.cs.CsReplyService;
import com.example.winwin.vo.board.CsReplyVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
    @RequiredArgsConstructor
    @RequestMapping("/replies/*")
    public class CsReplyController {
        private final CsReplyService csReplyService;

        @PostMapping("/reply")
        public String replyRegister(@RequestBody CsCommentDto csCommentDto, HttpServletRequest req){
            Long userNumber = (Long)req.getSession().getAttribute("userNumber");
            csCommentDto.setUserNumber(userNumber);
            csReplyService.register(csCommentDto);
            return "작성 성공!";
        }

        @GetMapping("/list{csNumber}")
        public List<CsReplyVo> getCommentList(@PathVariable("csNumber") Long csNumber){
            System.out.println("csNumber"+csNumber);
           return csReplyService.findList(csNumber);
        }


        @PatchMapping("/{csNumber}")
        public void commentModify(@PathVariable("csNumber") Long commentNumber, @RequestBody CsCommentDto csCommentDto){
            csCommentDto.setCommentNumber(commentNumber);
            csReplyService.modify(csCommentDto);
        }

        @GetMapping("/{csNumber}")
        public CsReplyVo commentView(@PathVariable("csNumber") Long commentNumber){
            return csReplyService.findComment(commentNumber);
        }

        @DeleteMapping("/{csNumber}")
        public void commentRemove(@PathVariable("csNumber") Long commentNumber){
           csReplyService.remove(commentNumber);
        }

    }