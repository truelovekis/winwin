package com.example.winwin.controller.myPage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myPage/*")
public class MyPageController {

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

    @GetMapping("myMentor")
    public String myMentor(){
        return "myPage/myMentor";
    }

    @GetMapping("myMentee")
    public String myMentee(){
        return "myPage/myMentee";
    }

    @GetMapping("resume")
    public String resume(){
        return "myPage/resume";
    }

    @GetMapping("resumeModal")
    public String resumeModal(){
        return "myPage/resumeModal";
    }

    @GetMapping("resumePR")
    public String resumePR(){
        return "myPage/resumePR";
    }

    @GetMapping("resumePrModal")
    public String resumePrModal(){
        return "myPage/resumePrModal";
    }

    @GetMapping("resumeWrite")
    public String resumeWrite(){
        return "myPage/resumeWrite";
    }

    @GetMapping("resumePrWrite")
    public String resumePrWrite(){
        return "myPage/resumePrWrite";
    }

    @GetMapping("userDelete")
    public String userDelete(){
        return "myPage/userDelete";
    }

    @GetMapping("userInfoModify")
    public String userInfoModiy(){
        return "myPage/userInfoModify";
    }

    @GetMapping("myRecord")
    public String myRecord(){
        return "myPage/myRecord";
    }
}
