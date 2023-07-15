package com.example.winwin.controller.myPage;

import com.example.winwin.dto.chatting.ChattingDto;
import com.example.winwin.dto.file.ResumeFileDto;
import com.example.winwin.dto.mentor.MentorVo;
import com.example.winwin.dto.user.ResumePrDto;
import com.example.winwin.service.chatting.ChattingService;
import com.example.winwin.service.myPage.MyPageService;
import com.example.winwin.vo.infinityScroll.Criteria;
import com.example.winwin.vo.infinityScroll.PageVo;
import com.example.winwin.vo.myPage.ActiveBoardVo;
import com.example.winwin.vo.myPage.ActiveCommentVo;
import com.example.winwin.vo.myPage.ResumeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/myPages/*")
public class MyPageRestController {
    private final MyPageService myPageService;
    private final ChattingService chattingService;

    @GetMapping("/resume")
    public ResumeVo getResume(HttpServletRequest req, Long resumeNumber){
        if(resumeNumber == null){
            throw new IllegalArgumentException("존재하지 않는 이력서입니다.");
        }
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        ResumeVo resumeVo = new ResumeVo();

        resumeVo.setResumeDto(myPageService.getResume(resumeNumber));
        resumeVo.setUserPhoneNumber(myPageService.getPhoneNumber(userNumber));
        resumeVo.setResumeFileDto(myPageService.getResumeFile(resumeNumber));

        return resumeVo;
    }

    @GetMapping("/pr")
    public ResumePrDto getPr(Long prNumber){
        if(prNumber == null){
            throw new IllegalArgumentException("존재하지 않는 자기소개서입니다.");
        }

        ResumePrDto resumePrDto = myPageService.getPr(prNumber);
        return resumePrDto;
    }

    @GetMapping("/myBoard/{page}")
    public Map<String, Object> myBoard(HttpServletRequest req, @PathVariable("page") int page) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(5);
        PageVo pageVo = new PageVo(criteria, myPageService.getBoardCnt(userNumber));
        List<ActiveBoardVo> activeBoardVoList = myPageService.getActiveBoardList(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("activeBoardVoList", activeBoardVoList);

        return myBoard;
    }

    @GetMapping("/myComment/{page}")
    public Map<String, Object> myComment(HttpServletRequest req, @PathVariable("page") int page) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(5);
        PageVo pageVo = new PageVo(criteria, myPageService.getCommentCnt(userNumber));
        List<ActiveCommentVo> activeCommentVoList = myPageService.getActiveCommentList(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("activeCommentVoList", activeCommentVoList);

        return myBoard;
    }
}
