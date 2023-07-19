package com.example.winwin.controller.meeting;

import com.example.winwin.service.board.StudyService;
import com.example.winwin.vo.board.StudyVo;
import com.example.winwin.vo.infinityScroll.Criteria;
import com.example.winwin.vo.infinityScroll.PageVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes/*")
public class projectLikeController {
    private final StudyService studyService;

    @Value("${pfp.dir}")
    private String pfpDir;

    @PostMapping("/{studyNumber}")
    public void likeRegister(@PathVariable("studyNumber") Long studyNumber, HttpServletRequest req) {
        studyService.likeProcess((Long) req.getSession().getAttribute("userNumber"), studyNumber);
    }

    @GetMapping("/{studyNumber}")
    public int getLikeCnt(@PathVariable("studyNumber") Long studyNumber, HttpServletRequest req) {
        return studyService.findLikeCnt((Long) req.getSession().getAttribute("userNumber"), studyNumber);
    }

      @GetMapping("/recruiting/{page}")
  public Map<String, Object> Scroll(@PathVariable("page") int page, Integer categoryNumber) {
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(5);
        List<StudyVo> StudyVoList = studyService.getRecruitingProjects(categoryNumber, criteria);
        int total = studyService.getRecruitingTotal(categoryNumber);
        PageVo pageVo = new PageVo(criteria, total);

        Map<String, Object> scroll = new HashMap<>();
        scroll.put("pageVo", pageVo);
        scroll.put("StudyVoList", StudyVoList);

        return scroll;
    }

    @GetMapping("/profile/{userNumber}")
    public byte[] getProfileImage(@PathVariable("userNumber") Long userNumber) throws IOException {
        StudyVo studyVo = studyService.findUserProfile(userNumber);
        String path = studyVo.getPfpUuId() + "_" + studyVo.getPfpSystemName();

        return FileCopyUtils.copyToByteArray(new File(pfpDir, path));
    }
}
