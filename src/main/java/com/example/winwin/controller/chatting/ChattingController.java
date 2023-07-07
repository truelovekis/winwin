package com.example.winwin.controller.chatting;

import com.example.winwin.dto.chatting.ChattingDto;
import com.example.winwin.service.chatting.ChattingService;
import com.example.winwin.vo.myPage.ChattingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.reactive.result.view.RedirectView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chatting/*")
public class ChattingController {

    private final ChattingService chattingService;

    @GetMapping("/sendModal")
    public String sendModal(){
        return "chatting/sendModal";
    }

    @GetMapping("/inputModal")
    public String inputModal(){
        return "chatting/inputModal";
    }

    @PostMapping("/sendModal")
    public RedirectView chattingSelectModal(Long chattingNumber, Model model){
        ChattingVo chattingVo = chattingService.chattingSelectModal(chattingNumber);

        model.addAttribute("chattingVo", chattingVo);

        return new RedirectView("/chatting/sendModal");
    }



}











