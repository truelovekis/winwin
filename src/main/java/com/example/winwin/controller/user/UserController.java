package com.example.winwin.controller.user;

import com.example.winwin.dto.user.UserDto;
import com.example.winwin.service.mentor.LoginService;
import com.example.winwin.service.mentor.MentorService;
import com.example.winwin.service.user.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @GetMapping
    public String loginModal(){
        return "user/loginModal";
    }

//    @PostMapping("/loginModal")
//    public RedirectView join(UserDto userDto){
//        userService.userRegister(userDto);
//        return new RedirectView("/user/loginModal");
//    }

    @PostMapping("/login")
    public RedirectView login(String userId, String userPassword, HttpServletRequest req){
        try {
            Long userNumber = userService.findUserNumber(userId, userPassword);
            UserDto userDto = userService.findUserInfo(userNumber);
            HttpSession session = req.getSession();
            session.setAttribute("userNumber", userNumber);
            session.setAttribute("userName", userDto.getUserName());
            session.setAttribute("userWing", userDto.getUserWing());

            Long mentorNumber = loginService.findMentorNumber(userId, userPassword);
            session.setAttribute("mentorNumber", mentorNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return new RedirectView("/user/login");
        }
        return new RedirectView("/main/main");
    }

//    @PostMapping("/checkId")
//    public int joinCheck(UserDto userDto, HttpServletRequest req){
//        HttpSession session = req.getSession();
//        session.setAttribute("userId", userDto.getUserId());
//        return 1;
//    }



}
