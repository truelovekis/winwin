package com.example.winwin.controller.user;

import com.example.winwin.dto.user.UserDto;
import com.example.winwin.service.user.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userSms/v1/*")
public class SmsController {

    private final SmsService smsService;

    @PostMapping("/send")
    public Mono<Map> sendMsg(@RequestBody Map<String, String> body, HttpServletRequest req){
        String phoneNumber = body.get("phoneNumber");
        Map<String, Object> map = smsService.sendMessage(phoneNumber);
        String authNumber = (String) map.get("authNumber");
        Mono<Map> resultBody = (Mono<Map>) map.get("resultBody");
        req.getSession().setAttribute("authNumber", authNumber);
        return resultBody;
//        String authNumber = smsService.sendMessage(phoneNumber);
//        req.getSession().setAttribute("authNumber", authNumber);
//        return "성공!";
    }

    @PostMapping("/check")
    public boolean checkNumber(String authNumber, HttpServletRequest req){
        String sessionNumber = (String)req.getSession().getAttribute("authNumber");
        req.getSession().setMaxInactiveInterval(3*60);
        System.out.println("authNumber : " + authNumber);
        System.out.println("sessionNumber : " + sessionNumber );
        return authNumber.equals(sessionNumber);
    }

    /* 아이디 찾기 */
    @PostMapping("/findId")
    public String findId(String authNumber, String userName, String phoneNumber, HttpServletRequest req){
        String sessionNumber = (String)req.getSession().getAttribute("authNumber");
        req.getSession().setMaxInactiveInterval(3*60);
        String userId = "일치하는 회원 정보가 없습니다.";

        System.out.println("authNumber : " + authNumber);
        System.out.println("sessionNumber : " + sessionNumber );
        System.out.println(userName);
        System.out.println(phoneNumber);

        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setUserPhoneNumber(phoneNumber);

        if(authNumber.equals(sessionNumber)){
            userId = smsService.findID(userDto);
        }

        return userId;
    }

    /* 비밀번호 찾기 */
    @PostMapping("/findPw")
    public String findPw(String authNumber, String userId, String phoneNumber, HttpServletRequest req){
        String sessionNumber = (String)req.getSession().getAttribute("authNumber");
        req.getSession().setMaxInactiveInterval(3*60);
        String userPw = "일치하는 회원 정보가 없습니다.";

        System.out.println("authNumber : " + authNumber);
        System.out.println("sessionNumber : " + sessionNumber );
        System.out.println(userId);
        System.out.println(phoneNumber);

        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setUserPhoneNumber(phoneNumber);

        if(authNumber.equals(sessionNumber)){
            userPw = smsService.findPw(userDto);
        }

        return userPw;
    }


}
