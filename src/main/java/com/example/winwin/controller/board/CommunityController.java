package com.example.winwin.controller.board;

import com.example.winwin.dto.board.CommunityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class CommunityController {

    @GetMapping("/read")
    public String board (){
        return "/community/communityRead";
    }
}
