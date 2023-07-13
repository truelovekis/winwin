package com.example.winwin.controller.chatting;

import com.example.winwin.dto.chatting.ChattingDto;
import com.example.winwin.service.chatting.ChattingService;
import com.example.winwin.vo.myPage.ChattingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chattings/*")
public class ChattingRestController {
    private final ChattingService chattingService;

    /* 쪽지 보내기 */
    @PostMapping("/inputModal")
    public void sendChatting(@RequestBody ChattingDto chattingDto, HttpServletRequest req){
        Long chattingFrom = (Long)req.getSession().getAttribute("userNumber");
        chattingDto.setChattingFrom(chattingFrom);

        System.out.println(chattingDto);
        chattingService.sendChatting(chattingDto);
    }

    /* 쪽지 확인 */
    @GetMapping("/sendModal")
    public ChattingVo chattingSelectModel(Long chattingNumber){
        if(chattingNumber==null){
            return null;
        }
        ChattingVo chattingVo = chattingService.chattingSelectModal(chattingNumber);

        return chattingVo;
    }

    /* 쪽지 확인 */
    @GetMapping("/sendModal2")
    public ChattingVo chattingSendModel(Long chattingNumber){
        if(chattingNumber==null){
            return null;
        }
        ChattingVo chattingVo = chattingService.chattingSendModal(chattingNumber);

        return chattingVo;
    }
}
