package com.example.winwin.controller.cs;

import com.example.winwin.dto.board.CommunityCommentDto;
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
        System.out.println("11111111111111111111111"+commentNumber);
        csCommentDto.setCommentNumber(commentNumber);
        System.out.println("222222222222222");
        csReplyService.modify(csCommentDto);
        System.out.println("555555555555555555");
    }

    @GetMapping("/{commentNumber}")
    public CsReplyVo commentView(@PathVariable("commentNumber") Long commentNumber) {
        return csReplyService.findComment(commentNumber);
    }

    @DeleteMapping("/{commentNumber}")
    public void commentRemove(@PathVariable("commentNumber") Long commentNumber) {
        csReplyService.remove(commentNumber);
    }

}