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
public class CsReplyRestController {
    private final CsReplyService csReplyService;

    @PostMapping("/reply")
    public String replyRegister(@RequestBody CsCommentDto csCommentDto, HttpServletRequest req) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        csCommentDto.setUserNumber(userNumber);
        csReplyService.register(csCommentDto);
        return "작성 성공!";
    }

    @GetMapping("/list{csNumber}")
    public List<CsReplyVo> getCommentList(@PathVariable("csNumber") Long csNumber) {
        System.out.println("csNumber" + csNumber);
        return csReplyService.findList(csNumber);
    }


    @PatchMapping("/{commentNumber}")
    public void commentModify(@PathVariable("commentNumber") Long commentNumber, @RequestBody CsCommentDto csCommentDto) {
        System.out.println("modify 레컨 들어옴");
        csCommentDto.setCommentNumber(commentNumber);
        csReplyService.modify(csCommentDto);
        System.out.println("레컨 끝남");
    }

    @GetMapping("/{commentNumber}")
    public CsReplyVo commentView(@PathVariable("commentNumber") Long commentNumber) {
        return csReplyService.findComment(commentNumber);
    }


    @DeleteMapping("/{commentNumber}")
    public void commentRemove(@PathVariable("commentNumber") Long commentNumber) {
        System.out.println("zzzzzzzzzzzzzzzzzz");
        csReplyService.remove(commentNumber);
        System.out.println("완료");
    }

}