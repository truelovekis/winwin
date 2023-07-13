package com.example.winwin.controller.qna;

import com.example.winwin.dto.board.QnaGoodDto;
import com.example.winwin.service.qna.QnaGoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qnaLikes/*")
public class QnaGoodController {

    private final QnaGoodService qnaGoodService;

    @PostMapping("/qnaLikeUp")
    public void likeUp(@RequestBody QnaGoodDto qnaGoodDto){
        System.out.println("레스트 컨트롤러 연결 성공!!!!!!!!!!!!");
        System.out.println(qnaGoodDto.getQnaNumber());
        System.out.println(qnaGoodDto.getUserNumber());
        qnaGoodService.qnaLikeUp(qnaGoodDto);

    }

    @DeleteMapping("/qnaLikeDown")
    public void unlike(@RequestBody QnaGoodDto qnaGoodDto){
        System.out.println("좋아요, 싫어요 연결 성공!!!!!!!!!!!!!!!!");
        System.out.println("===========================뭔데요"+qnaGoodDto);
        qnaGoodService.qnaLikeDown(qnaGoodDto);
    }
}
