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
import javax.servlet.http.PushBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/myPages/*")
public class MyPageRestController {
    private final MyPageService myPageService;
    private final ChattingService chattingService;

//    이력서 모달창 띄우기
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

//    자기소개서 모달창 띄우기
    @GetMapping("/pr")
    public ResumePrDto getPr(Long prNumber){
        if(prNumber == null){
            throw new IllegalArgumentException("존재하지 않는 자기소개서입니다.");
        }

        ResumePrDto resumePrDto = myPageService.getPr(prNumber);
        return resumePrDto;
    }

//    내 작성 글 전체보기
    @GetMapping("/myBoard/{page}")
    public Map<String, Object> myBoard(HttpServletRequest req, @PathVariable("page") int page) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(4);
        PageVo pageVo = new PageVo(criteria, myPageService.getBoardCnt(userNumber));
        List<ActiveBoardVo> activeBoardVoList = myPageService.getActiveBoardList(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("activeBoardVoList", activeBoardVoList);

        return myBoard;
    }

    //    내 QnA 글 전체보기
    @GetMapping("/myQna/{page}")
    public Map<String, Object> myQna(HttpServletRequest req, @PathVariable("page") int page) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(4);
        PageVo pageVo = new PageVo(criteria, myPageService.getTotalQna(userNumber));
        List<ActiveBoardVo> activeBoardVoList = myPageService.getActiveQnaBoardList(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("activeBoardVoList", activeBoardVoList);

        return myBoard;
    }

    //    내 커뮤니티 글 전체보기
    @GetMapping("/myCommunity/{page}")
    public Map<String, Object> myCommunity(HttpServletRequest req, @PathVariable("page") int page) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(4);
        PageVo pageVo = new PageVo(criteria, myPageService.getTotalCommunity(userNumber));
        List<ActiveBoardVo> activeBoardVoList = myPageService.getActiveCommunityBoardList(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("activeBoardVoList", activeBoardVoList);

        return myBoard;
    }

    //    내 모임 글 전체보기
    @GetMapping("/myMeeting/{page}")
    public Map<String, Object> myMeeting(HttpServletRequest req, @PathVariable("page") int page) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(4);
        PageVo pageVo = new PageVo(criteria, myPageService.getTotalMeeting(userNumber));
        List<ActiveBoardVo> activeBoardVoList = myPageService.getActiveMeetingBoardList(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("activeBoardVoList", activeBoardVoList);

        return myBoard;
    }

    //    내 나눔 글 전체보기
    @GetMapping("/myShare/{page}")
    public Map<String, Object> myShare(HttpServletRequest req, @PathVariable("page") int page) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(4);
        PageVo pageVo = new PageVo(criteria, myPageService.getTotalShare(userNumber));
        List<ActiveBoardVo> activeBoardVoList = myPageService.getActiveShareBoardList(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("activeBoardVoList", activeBoardVoList);

        return myBoard;
    }

    //    내 문의사항 글 전체보기
    @GetMapping("/myCs/{page}")
    public Map<String, Object> myCs(HttpServletRequest req, @PathVariable("page") int page) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(4);
        PageVo pageVo = new PageVo(criteria, myPageService.getTotalCs(userNumber));
        List<ActiveBoardVo> activeBoardVoList = myPageService.getActiveCsBoardList(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("activeBoardVoList", activeBoardVoList);

        return myBoard;
    }

//    내 진로정보 글 전체보기
    @GetMapping("/myCareerInfo/{page}")
    public Map<String, Object> myCareerInfo(HttpServletRequest req, @PathVariable("page") int page){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(9);
        PageVo pageVo = new PageVo(criteria, myPageService.getTotalCareerInfo(userNumber));
        List<ActiveBoardVo> activeBoardVoList = myPageService.getActiveCareerInfoBoardList(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("activeBoardVoList", activeBoardVoList);

        return myBoard;
    }

//    내 작성 댓글 전체보기
    @GetMapping("/myComment/{page}")
    public Map<String, Object> myComment(HttpServletRequest req, @PathVariable("page") int page) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(4);
        PageVo pageVo = new PageVo(criteria, myPageService.getCommentCnt(userNumber));
        List<ActiveCommentVo> activeCommentVoList = myPageService.getActiveCommentList(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("activeCommentVoList", activeCommentVoList);

        return myBoard;
    }

    //    내 QnA 작성 댓글 전체보기
    @GetMapping("/myQnaComment/{page}")
    public Map<String, Object> myQnaComment(HttpServletRequest req, @PathVariable("page") int page) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(4);
        PageVo pageVo = new PageVo(criteria, myPageService.getTotalQnaComment(userNumber));
        List<ActiveCommentVo> activeCommentVoList = myPageService.getActiveQnaCommentList(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("activeCommentVoList", activeCommentVoList);
        System.out.println("activeCommentVoListactiveCommentVoList : "+activeCommentVoList);
        return myBoard;
    }

    //    내 커뮤니티 작성 댓글 전체보기
    @GetMapping("/myCommunityComment/{page}")
    public Map<String, Object> myCommunityComment(HttpServletRequest req, @PathVariable("page") int page) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(4);
        PageVo pageVo = new PageVo(criteria, myPageService.getTotalCommunityComment(userNumber));
        List<ActiveCommentVo> activeCommentVoList = myPageService.getActiveCommunityCommentList(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("activeCommentVoList", activeCommentVoList);

        return myBoard;
    }


}
