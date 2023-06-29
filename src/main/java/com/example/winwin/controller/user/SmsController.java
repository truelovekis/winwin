package com.example.winwin.controller.user;

import com.example.winwin.service.user.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/v1/*")
public class SmsController {

    private final SmsService smsService;

    @PostMapping("/send")
    public void sendMsg(@RequestBody Map<String, String> body, HttpServletRequest req){
        String phoneNumber = body.get("phoneNumber");
        String authNumber = smsService.sendMessage(phoneNumber);
        req.getSession().setAttribute("authNumber", authNumber);

    }
}
