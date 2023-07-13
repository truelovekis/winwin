package com.example.winwin.controller.myPage;

import com.example.winwin.service.myPage.DiaryService;
import com.example.winwin.vo.infinityScroll.PageVo;
import com.example.winwin.vo.myPage.MyPageCriteria;
import com.example.winwin.vo.myPage.DiaryVo;
import com.example.winwin.vo.myPage.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary/*")
public class DiaryController {
    private final DiaryService diaryService;

    @PostMapping("/diary")
    public void registerDiary(DiaryVo diaryVo, HttpServletRequest req ){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        diaryVo.setUserNumber(userNumber);
        diaryService.register(diaryVo);
    }

    @GetMapping("/list")
    public List<DiaryVo> listDiary(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        return diaryService.findList(userNumber);
    }

    @PatchMapping("/update")
    public void modify(DiaryVo diaryVo ,Long diaryNumber){
        diaryVo.setDiaryNumber(diaryNumber);
        diaryService.modify(diaryVo);
    }

    @GetMapping("/scroll/{page}")
    public Map<String, Object> diaryListPage(@PathVariable("page") int page, HttpServletRequest req){
        System.out.println(page);
        System.out.println("====================================");
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        MyPageCriteria myPageCriteria = new MyPageCriteria();
        myPageCriteria.setPage(page);
        Page pageVo = new Page(myPageCriteria, diaryService.findTotal());
        List<DiaryVo> diaryList = diaryService.findListPage(myPageCriteria, userNumber);

        System.out.println(diaryList);

        Map<String, Object> diaryMap = new HashMap<>();

        diaryMap.put("pageVo", pageVo);
        diaryMap.put("diaryList", diaryList);

        return diaryMap;
    }
}
