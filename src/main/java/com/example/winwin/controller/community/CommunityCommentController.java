package com.example.winwin.controller.community;

import com.example.winwin.dto.board.CommunityCommentDto;
import com.example.winwin.service.board.CommunityCommentService;
import com.example.winwin.vo.board.CommunityCommentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment/*")
public class CommunityCommentController {
    private final CommunityCommentService communityCommentService;

    @PostMapping("/comment")
    public String commentRegister(@RequestBody CommunityCommentDto communityCommentDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        communityCommentDto.setUserNumber(9L);
        System.out.println(communityCommentDto);
        communityCommentService.register(communityCommentDto);
        return "작성 성공!";
    }

    @GetMapping("/list{communityNumber}")
    public List<CommunityCommentVo> getCommentList(@PathVariable("communityNumber") Long communityNumber){
        return communityCommentService.findList(communityNumber);
    }

    @PatchMapping("/{communityNumber}")
    public void commentModify(@PathVariable("commentNumber") Long commentNumber, @RequestBody CommunityCommentDto communityCommentDto){
        communityCommentDto.setCommentNumber(commentNumber);
        communityCommentService.modify(communityCommentDto);
    }

    @GetMapping("/{commentNumber}")
    public CommunityCommentVo commentView(@PathVariable("commentNumber") Long commentNumber){
        return communityCommentService.findComment(commentNumber);
    }

    @DeleteMapping("/{commentNumber}")
    public void commentRemove(@PathVariable("commentNumber") Long commentNumber){
        communityCommentService.remove(commentNumber);
    }

}
