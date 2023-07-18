package com.example.winwin.controller.chatting;

import com.example.winwin.dto.chatting.ChattingDto;
import com.example.winwin.dto.user.UserDto;
import com.example.winwin.service.chatting.ChattingService;
import com.example.winwin.service.share.ShareService;
import com.example.winwin.service.user.UserService;
import com.example.winwin.vo.infinityScroll.Criteria;
import com.example.winwin.vo.infinityScroll.PageVo;
import com.example.winwin.vo.myPage.ActiveBoardVo;
import com.example.winwin.vo.myPage.ChattingVo;
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
@RequestMapping("/chattings/*")
public class ChattingRestController {
    private final ChattingService chattingService;
    private final ShareService shareService;
    private final UserService userService;

    /* 쪽지 보내기 */
    @PostMapping("/inputModal")
    public void sendChatting(@RequestBody ChattingDto chattingDto, HttpServletRequest req) {
        Long chattingFrom = (Long) req.getSession().getAttribute("userNumber");
        chattingDto.setChattingFrom(chattingFrom);

        System.out.println(chattingDto);
        chattingService.sendChatting(chattingDto);
    }

    /* 나눔 쪽지 보내기 */
    @PostMapping("/shareModal/{shareNumber}/{wingAmount}")
    public void sendShareChatting(@RequestBody ChattingDto chattingDto, HttpServletRequest req,
                                  @PathVariable(value = "shareNumber", required = false) Long shareNumber, @PathVariable("wingAmount") int wingAmount) {
        Long chattingFrom = (Long) req.getSession().getAttribute("userNumber");
        chattingDto.setChattingFrom(chattingFrom);

        System.out.println("===============================");
        System.out.println(chattingDto);
        System.out.println(wingAmount);
        System.out.println("===============================");
        chattingService.sendChatting(chattingDto);
        shareService.modifyShareStatus(shareNumber);
        shareService.wingTrade(wingAmount, chattingDto.getChattingFrom(), chattingDto.getChattingTo());
        UserDto userDto = userService.findUserInfo(chattingFrom);
        req.getSession().setAttribute("userWing", userDto.getUserWing());
    }

    /* 쪽지 확인 (받은 쪽지) */
    @GetMapping("/sendModal")
    public ChattingVo chattingSelectModel(Long chattingNumber) {
        if (chattingNumber == null) {
            return null;
        }
        ChattingVo chattingVo = chattingService.chattingSelectModal(chattingNumber);

        return chattingVo;
    }

    /* 쪽지 확인 (보낸 쪽지) */
    @GetMapping("/sendModal2")
    public ChattingVo chattingSendModel(Long chattingNumber) {
        if (chattingNumber == null) {
            return null;
        }
        ChattingVo chattingVo = chattingService.chattingSendModal(chattingNumber);

        return chattingVo;
    }

    // 받은 메세지 조회
    @GetMapping("/receiveMessage/{page}")
    public Map<String, Object> chattingSelect(HttpServletRequest req, @PathVariable("page") int page) {
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");

        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(5);
        PageVo pageVo = new PageVo(criteria, chattingService.chattingReceiveAll(userNumber));
        List<ChattingVo> chattingVoList = chattingService.chattingSelect(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("chattingVoList", chattingVoList);

        return myBoard;
    }

    // 보낸 메세지 조회
    @GetMapping("/sendMessage/{page}")
    public Map<String, Object> chattingSelectFrom(HttpServletRequest req, @PathVariable("page") int page) {
        System.out.println("11111111111111111");
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        System.out.println("22222222222222222222222");
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(5);
        PageVo pageVo = new PageVo(criteria, chattingService.chattingSendAll(userNumber));
        List<ChattingVo> chattingVoList = chattingService.chattingSelectFrom(userNumber, criteria);

        Map<String, Object> myBoard = new HashMap<>();
        myBoard.put("pageVo", pageVo);
        myBoard.put("chattingVoList", chattingVoList);

        System.out.println(chattingVoList);

        return myBoard;
    }

}
