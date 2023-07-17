package com.example.winwin.controller.careerInfo;

import com.example.winwin.dto.careerInfo.CareerInfoCommentDto;
import com.example.winwin.dto.careerInfo.CareerInfoCommentVo;
import com.example.winwin.dto.mentor.CareerInfoVo;
import com.example.winwin.service.career.CareerInfoCommentService;
import com.example.winwin.service.career.CareerInfoLikeService;
import com.example.winwin.vo.infinityScroll.Criteria;
import com.example.winwin.vo.infinityScroll.PageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/careerReplies/*")
public class CareerInfoCommentRestController {

    private final CareerInfoCommentService careerInfoCommentService;

//    진로정보 댓글 작성하기
    @PostMapping("/comment")
    public void commentRegegister(@RequestBody CareerInfoCommentDto careerInfoCommentDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        careerInfoCommentDto.setUserNumber(userNumber);

        careerInfoCommentService.careerInfoCommentRegister(careerInfoCommentDto);

    }

//    진로정보 댓글 최신순으로 조회하기 및 무한스크롤
    @GetMapping("/list/{careerInfoNumber}/{page}")
    public Map<String, Object> commentListPage(@PathVariable("careerInfoNumber") Long careerInfoNumber,
                                @PathVariable("page") int page){
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        PageVo pageVo = new PageVo(criteria, careerInfoCommentService.findTotal(careerInfoNumber));
        List<CareerInfoCommentVo> careerInfoCommentList = careerInfoCommentService.careerInfoCommnetList(criteria, careerInfoNumber);

        System.out.println(careerInfoCommentList.size());

        Map<String, Object> careerCommentMap = new HashMap<>();
        careerCommentMap.put("pageVo", pageVo);
        careerCommentMap.put("careerInfoCommentList", careerInfoCommentList);

        return careerCommentMap;
    }

//    진로정보 댓글 수정하기
    @PatchMapping("/{commentNumber}")
    public void commentModify(@PathVariable("commentNumber") Long commentNumber,
                              @RequestBody CareerInfoCommentDto careerInfoCommentDto){

    careerInfoCommentDto.setCommentNumber(commentNumber);
    careerInfoCommentService.careerInfoCommentModify(careerInfoCommentDto);
    }

//    회원이 등록한 댓글 조회하기
    @GetMapping("/{commentNumber}")
    public CareerInfoCommentVo commentView(@PathVariable("commentNumber") Long commentNumber) {

        return careerInfoCommentService.findUserReply(commentNumber);
    }

//    댓글 번호로 삭제하기
    @DeleteMapping("/{commentNumber}")
    public void commentRemove(@PathVariable("commentNumber") Long commentNumber){

        careerInfoCommentService.careerInfoCommentRemove(commentNumber);
    }
}
