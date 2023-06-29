package com.example.winwin.controller.share;


import com.example.winwin.dto.share.ShareDto;
import com.example.winwin.service.file.ShareFileService;
import com.example.winwin.service.share.ShareService;
import com.example.winwin.vo.share.ShareVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Controller
@RequestMapping("/share/*")
@RequiredArgsConstructor
public class ShareController {

    private final ShareService shareService;
    private final ShareFileService shareFileService;

//    나눔 페이지 단순 이동
    @GetMapping("/list")
    public String shareList(Model model){

        List<ShareVo> shareVoList = shareService.shareFindAll();

//        글 작성 몇 분전 보여주기
        if(shareVoList.size() > 0){
            for (ShareVo shareVo: shareVoList) {

                // reg_date를 LocalDateTime으로 변환
                LocalDateTime communityDate = LocalDateTime.parse(shareVo.getShareDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                // 현재 시간과의 차이 계산
                long minutesDiff = ChronoUnit.MINUTES.between(communityDate, LocalDateTime.now());
                long hoursDiff = ChronoUnit.HOURS.between(communityDate, LocalDateTime.now());
                long daysDiff = ChronoUnit.DAYS.between(communityDate, LocalDateTime.now());

                // 경과 시간 표시
                if (minutesDiff < 60) {
                    shareVo.setShareDate(minutesDiff + "분 전");
                } else if (hoursDiff < 24) {
                    shareVo.setShareDate(hoursDiff + "시간 전");
                } else if (daysDiff < 365) {
                    shareVo.setShareDate(daysDiff + "일 전");
                }
            }
        }

        model.addAttribute("shareList", shareVoList);

        return "share/share";
    }



//    나눔 글 작성 페이지 단순 이동
    @GetMapping("/write")
    public String shareWrite(HttpServletRequest req){

        return "/share/shareWrite";
    }

//    나눔 글 작성하기
    @PostMapping("/write")
    public RedirectView shareWrite(ShareDto shareDto, HttpServletRequest req, RedirectAttributes redirectAttributes,
                                   @RequestParam("shareFile") List<MultipartFile> files){
//        로그인 완려되면 주석해제하기
//        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
//        shareDto.setUserNumber(userNumber);
        shareService.shareRegister(shareDto);

        System.out.println("====================================");
        System.out.println(files);
        System.out.println("====================================");
        redirectAttributes.addFlashAttribute("shareNumber", shareDto.getShareNumber());

//      C:/upload/파일에 첨부파일 저장하기
        try {
            if(files != null){
                shareFileService.registerAndSaveFiles(files, shareDto.getShareNumber());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new RedirectView("/share/list");
    }

//    나눔 글 상세보기 단순 이동
    @GetMapping("/read")
    public String shareRead (Long shareNumber, Model model){
        ShareVo shareVo = shareService.findShare(shareNumber);
        model.addAttribute("share", shareVo);

        return "share/shareRead";
    }

//    나눔 글 수정하기 단순 이동
    @GetMapping("/modify")
    public String shareModify(Long shareNumber, Model model){
        ShareVo shareVo = shareService.findShare(shareNumber);
        model.addAttribute("share", shareVo);

        return "share/shareModify";
    }

//    나눔 글 수정하기 이동
    @PostMapping("/modify")
    public RedirectView sharemodify(ShareDto shareDto, RedirectAttributes redirectAttributes,
                              @RequestParam("shareFile") List<MultipartFile> files){

        try {
            shareService.shareModify(shareDto, files);
        } catch (IOException e) {
            e.printStackTrace();
        }

        redirectAttributes.addAttribute("shareNumber", shareDto.getShareNumber());

        return new RedirectView("/share/read");
    }

//    나눔 글 삭제하기
    @GetMapping("/remove")
    public RedirectView shareRemove(Long shareNumber){
        shareService.shareRemove(shareNumber);

        return new RedirectView("/share/list");
    }

//    나눔 글 신고하기
    @GetMapping("/report")
    public RedirectView shareReport(Long shareNumber){
//        shareService.findShare(shareNumber);

        return new RedirectView("/share/report");
    }

}
