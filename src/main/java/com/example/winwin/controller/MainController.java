package com.example.winwin.controller;

import com.example.winwin.dto.user.MentorDto;
import com.example.winwin.dto.user.UserDto;
import com.example.winwin.service.user.UserService;
import com.example.winwin.vo.user.CategoryBridgeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

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
    public RedirectView header(UserDto userDto, @RequestParam("subNumber") List<Integer> subNumbers){
        System.out.println(userDto);
        System.out.println(subNumbers);
        userService.userRegister(userDto);

        CategoryBridgeVo categoryBridgeVo = new CategoryBridgeVo();
        categoryBridgeVo.setUserNumber(userDto.getUserNumber());

//        MentorDto mentorDto = new MentorDto();
//        mentorDto.setUserNumber(userDto.getUserNumber());

        for(int i : subNumbers){
            categoryBridgeVo.setSubNumber(i);
            userService.categoryBridge(categoryBridgeVo);
        }


        if(userDto.getUserPosition().equals("mentor") || userDto.getUserPosition().equals("mentorMentee")){
            MentorDto mentorDto = new MentorDto();
            mentorDto.setUserNumber(userDto.getUserNumber());

            userService.joinMentor(mentorDto);

//            for(int i : subNumbers){
//                mentorDto.setSubNumber(i);
//                userService.joinMentor(mentorDto);
//            }
        }


        return new RedirectView("/main/main");
    }
}
