package com.example.winwin.controller;

import com.example.winwin.dto.user.UserDto;
import com.example.winwin.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainController {

    private final UserService userService;

    @GetMapping("/main")
    public String main(){
        return"main/main";
    };

    @PostMapping("/main")
    public RedirectView header(UserDto userDto){
        System.out.println(userDto);
        userService.userRegister(userDto);

        return new RedirectView("/main/main");
    }
}
