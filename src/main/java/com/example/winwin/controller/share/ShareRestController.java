package com.example.winwin.controller.share;

import com.example.winwin.service.share.ShareService;
import com.example.winwin.vo.infinityScroll.Criteria;
import com.example.winwin.vo.infinityScroll.PageVo;
import com.example.winwin.vo.share.ShareVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/scroll/*")
@RequiredArgsConstructor
public class ShareRestController {

    private final ShareService shareService;

//  무한 스크롤 RestController
    @GetMapping("/list/{page}")
    public Map<String, Object> shareListPage(@PathVariable("page") int page){
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        PageVo pageVo = new PageVo(criteria, shareService.findTotal());
        List<ShareVo> shareList = shareService.findListPage(criteria);

        Map<String, Object> shareMap = new HashMap<>();
        shareMap.put("pageVo", pageVo);
        shareMap.put("shareList", shareList);

        return shareMap;
    }
}
