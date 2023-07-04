package com.example.winwin.controller.mentor;

import com.example.winwin.dto.mentor.LoginVo;
import com.example.winwin.dto.mentor.MentorVo;
import com.example.winwin.dto.user.UserDto;
import com.example.winwin.service.mentor.LoginService;
import com.example.winwin.service.mentor.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mentors/*")
public class LoginMentorController {
    private final LoginService loginService;

    @PostMapping("/mentor")
    public int login(@RequestBody LoginVo loginVo, HttpServletRequest req){
        try {
            Long mentorNumber = loginService.findMentorNumber(loginVo.getUserId(), loginVo.getUserPassword());
            req.getSession().setAttribute("mentorNumber", mentorNumber);
            System.out.println(mentorNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

}
