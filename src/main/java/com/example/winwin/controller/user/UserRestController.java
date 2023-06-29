package com.example.winwin.controller.user;

import com.example.winwin.dto.user.UserDto;
import com.example.winwin.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/*")
public class UserRestController {
    private final UserService userService;

    @PostMapping("/login")
    public int login(@RequestBody UserDto userDto, HttpServletRequest req){
        try {
            Long userNumber = userService.findUserNumber(userDto.getUserId(), userDto.getUserPassword());
            UserDto userInfo = userService.findUserInfo(userNumber);

            System.out.println(userNumber);
            System.out.println(userInfo.getUserName());
            System.out.println(userInfo.getUserWing());

            req.getSession().setAttribute("userNumber", userNumber);
            req.getSession().setAttribute("userName", userInfo.getUserName());
            req.getSession().setAttribute("userWing", userInfo.getUserWing());

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @PostMapping("/checkId")
    public int checkId(@RequestParam("userId") String userId) {
        System.out.println("param : " + userId);

        int checkNum = userService.checkId(userId);

        System.out.println(checkNum);

        if(checkNum == 0) {
            System.out.println("아이디 사용 가능");
            return 0;
        }else{
            System.out.println("아이디가 중복되었다.");
            return 1;
        }
    }

    @PostMapping("/checkNickname")
    public int checkNickname(@RequestParam("userNickname") String userNickname) {
        System.out.println("param : " + userNickname);

        int checkNum = userService.checkNickname(userNickname);

        System.out.println(checkNum);

        if(checkNum == 0) {
            System.out.println("닉네임 사용 가능");
            return 0;
        }else{
            System.out.println("닉네임 중복");
            return 1;
        }
    }
}
