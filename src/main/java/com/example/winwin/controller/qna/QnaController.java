package com.example.winwin.controller.qna;

import com.example.winwin.dto.board.QnaDto;
import com.example.winwin.dto.board.QsBridgeDto;
import com.example.winwin.service.board.CommunityService;
import com.example.winwin.service.qna.QnaService;
import com.example.winwin.vo.board.QsBridgeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/qna/*")
@RequiredArgsConstructor
public class QnaController {

    private final QnaService qnaService;

    @GetMapping("/read")
    public String qnaRead(){
        return "/qna/qnaRead";
    }

    @GetMapping("/write")
    public String qnaWrite(HttpServletRequest req, Model model){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        return "/qna/qnaWrite";
    }

    @PostMapping("/write")
    public RedirectView qnaWriteOk(QnaDto qnaDto, HttpServletRequest req, RedirectAttributes redirectAttributes){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        qnaDto.setUserNumber(userNumber);
        qnaService.registerQna(qnaDto);
        System.out.println("=========="+qnaDto);
//        qsBridgeDto.setQnaNumber(qnaDto.getQnaNumber());
//        System.out.println("=========="+qsBridgeDto);
//        qnaService.registerQs(qsBridgeDto);
        redirectAttributes.addFlashAttribute("qnaNumber", qnaDto.getQnaNumber());
        return new RedirectView("/qna/list");
    }

    @GetMapping("/list")
    public String qnaList() {return "/qna/qna";}
}
