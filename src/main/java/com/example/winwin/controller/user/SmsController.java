package com.example.winwin.controller.user;

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
        System.out.println(phoneNumber);
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
}
