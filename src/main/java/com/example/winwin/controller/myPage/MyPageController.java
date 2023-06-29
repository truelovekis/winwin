package com.example.winwin.controller.myPage;

import com.example.winwin.dto.user.UserDto;
import com.example.winwin.dto.user.UserPfpDto;
import com.example.winwin.service.myPage.MyPageService;
import com.example.winwin.vo.myPage.MyPageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myPage/*")
public class MyPageController {
    private final MyPageService myPageService;

    @GetMapping("/activityComment")
    public String activityComment(){
        return "myPage/activityComment";
    }

    @GetMapping("/activityDetail")
    public String activityDetail(){
        return "myPage/activityDetail";
    }

    @GetMapping("/activityGive")
    public String activityGive(){
        return "myPage/activityGive";
    }

    @GetMapping("/activityProject")
    public String activityProject(){
        return "myPage/activityProject";
    }

    @GetMapping("/careerInfo")
    public String careerInfo(){
        return "myPage/careerInfo";
    }

    @GetMapping("/careerInfoLike")
    public String careerInfoLike(){
        return "myPage/careerInfoLike";
    }

    @GetMapping("/careerInfoReply")
    public String careerInfoReply(){
        return "myPage/careerInfoReply";
    }

    @GetMapping("/loveMentor")
    public String loveMentor(){
        return "myPage/loveMentor";
    }

    @GetMapping("/myMentor")
    public String myMentor(){
        return "myPage/myMentor";
    }

    @GetMapping("/myMentee")
    public String myMentee(){
        return "myPage/myMentee";
    }

    @GetMapping("/resume")
    public String resume(){
        return "myPage/resume";
    }

    @GetMapping("/resumeModal")
    public String resumeModal(){
        return "myPage/resumeModal";
    }

    @GetMapping("/resumePr")
    public String resumePR(){
        return "myPage/resumePr";
    }

    @GetMapping("/resumePrModal")
    public String resumePrModal(){
        return "myPage/resumePrModal";
    }

    @GetMapping("/resumeWrite")
    public String resumeWrite(){
        return "myPage/resumeWrite";
    }

    @GetMapping("/resumePrWrite")
    public String resumePrWrite(){
        return "myPage/resumePrWrite";
    }

    @GetMapping("/userDelete")
    public String userDelete(){
        return "myPage/userDelete";
    }

    @PostMapping("/userDelete")
    public String userDelete(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
//        myPageService.withdrawUser(userNumber);
        myPageService.withdrawUser(1L);

        return "main/main";
    }

    // 회원정보수정 페이지 이동
    @GetMapping("/userInfoModify")
    public String userInfoModify(HttpServletRequest req, Model model){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");

//        MyPageVo userInfo = myPageService.getUserInfo(userNumber);
        MyPageVo userInfo = myPageService.getUserInfo(1L);
        model.addAttribute("userInfo", userInfo);

//        UserPfpDto Profile = myPageService.getProfile(userNumber);
        UserPfpDto profile = myPageService.getProfile(1L);
        model.addAttribute("profile", profile);

        return "myPage/userInfoModify";
    }

    // 회원정보 수정하기
    @PostMapping("/userInfoModify")
    public RedirectView updateUserInfo(HttpServletRequest req, RedirectAttributes redirectAttributes,
                                       String userId, String userPassword, String userNickName,
                                       String userPhoneNumber, String userEmail,
                                       @RequestParam("pfpFile") MultipartFile file){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setUserPassword(userPassword);
//        userDto.setUserNumber(userNumber);
        userDto.setUserNumber(1L);
        userDto.setUserNickname(userNickName);
        userDto.setUserPhoneNumber(userPhoneNumber);
        userDto.setUserEmail(userEmail);
        redirectAttributes.addFlashAttribute("userDto", userDto);
        myPageService.updateUserInfo(userDto);

        if(file != null) {
            try {
//                myPageService.removeProfile(userNumber);
                myPageService.removeProfile(1L);
                UserPfpDto userPfpDto = myPageService.saveFile(file);
//                userPfpDto.setUserNumber(userNumber);
                userPfpDto.setUserNumber(1L);
                myPageService.registerProfile(userPfpDto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new RedirectView("/myPage/userInfoModify");
    }

    // 나의관심분야 수정하기
    @PostMapping("/interestTagModify")
    public RedirectView interestTagModify(HttpServletRequest req, RedirectAttributes redirectAttributes,
                                          @RequestParam("subNumber") List<String> tagList){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
//        myPageService.modifyInterestTag(userNumber, tagList);
        myPageService.modifyInterestTag(1L, tagList);

        MyPageVo userInfo = myPageService.getUserInfo(1L);
        redirectAttributes.addFlashAttribute("userInfo", userInfo);

        return new RedirectView("/myPage/userInfoModify");
    }

    // 프로필 이미지 수정하기
    @PostMapping("/userProfileModify")
    public RedirectView userProfileModify(HttpServletRequest req, RedirectAttributes redirectAttributes
                                          ){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        redirectAttributes.addFlashAttribute("userInfo", userNumber);
        return new RedirectView("/myPage/userInfoModify");
    }

    @GetMapping("/myRecord")
    public String myRecord(){
        return "myPage/myRecord";
    }
}
