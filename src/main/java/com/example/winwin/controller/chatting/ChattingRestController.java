package com.example.winwin.controller.chatting;

import com.example.winwin.dto.chatting.ChattingDto;
import com.example.winwin.service.chatting.ChattingService;
import com.example.winwin.vo.myPage.ChattingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chattings/*")
public class ChattingRestController {
    private final ChattingService chattingService;

    @PostMapping("/inputModal")
    public void sendChatting(@RequestBody ChattingDto chattingDto, HttpServletRequest req){
        Long chattingFrom = (Long)req.getSession().getAttribute("userNumber");
        chattingDto.setChattingFrom(chattingFrom);

//        System.out.println(chattingDto);
        chattingService.sendChatting(chattingDto);
    }

    @GetMapping("/sendModal")
    public ChattingVo chattingSelectModel(Long chattingNumber){
        if(chattingNumber==null){
            return null;
        }
        ChattingVo chattingVo = chattingService.chattingSelectModal(chattingNumber);

        return chattingVo;
    }
}
