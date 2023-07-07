package com.example.winwin.controller.community;

import com.example.winwin.service.board.CommunityGoodService;
import com.example.winwin.vo.board.CommunityGoodVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes/*")
public class CommunityGoodController {
    private final CommunityGoodService communityGoodService;

    @PostMapping("/likeUp")
    public void likeUp(@RequestBody CommunityGoodVo communityGoodVo) {
        System.out.println("레스트 컨트롤러 연결 성공!!!!!!!!!!!!");
        System.out.println(communityGoodVo.getCommunityNumber());
        System.out.println(communityGoodVo.getUserNumber());
        communityGoodService.likeUp(communityGoodVo);

    }

    @DeleteMapping("/unlike")
    public void unlike(@RequestBody CommunityGoodVo communityGoodVo) {
        System.out.println("좋아요, 싫어요 연결 성공!!!!!!!!!!!!!!!!");
        System.out.println("===========================뭔데요"+communityGoodVo);
        communityGoodService.unlike(communityGoodVo);
    }

}
