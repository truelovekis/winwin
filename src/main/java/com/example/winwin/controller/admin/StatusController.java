package com.example.winwin.controller.admin;

import com.example.winwin.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/status/*")
public class StatusController {

    private final AdminService adminService;

    // 커뮤니티 상태 변경
    @PostMapping("/update")
    public String modifyStatus(@RequestBody Map<String, List<String>> requestBody) {
        List<String> communityNumberList = requestBody.get("communityNumber");
        List<String> communityStatusList = requestBody.get("communityStatus");

        for(int i=0; i<communityNumberList.size(); i++){
            Long communityNumber = Long.parseLong(communityNumberList.get(i));
            String communityStatus = communityStatusList.get(i);

            adminService.modifyBoardStatus(communityNumber, communityStatus);
        }


        return "변경성공";
    }

    // 진로정보 상태 변경
    @PatchMapping("/updateCareer")
    public String modifyCareer(@RequestBody Map<String, List<String>> requestBody) {
        List<String> careerInfoNumberList = requestBody.get("careerInfoNumber");
        List<String> careerInfoStatusList = requestBody.get("careerInfoStatus");

        for (int i = 0; i < careerInfoNumberList.size(); i++) {
            Long careerInfoNumber = Long.parseLong(careerInfoNumberList.get(i));
            String careerInfoStatus = careerInfoStatusList.get(i);
        adminService.modifyCareerStatus(careerInfoNumber, careerInfoStatus);
        }
        return "변경성공";
    }

    // 나눔 상태 변경
    @PatchMapping("/updateShare")
    public String modifyShare(@RequestBody Map<String, List<String>> requestBody){
        List<String> shareNumberList = requestBody.get("shareNumber");
        List<String> shareStatusList = requestBody.get("shareStatus");

        for (int i=0; i< shareNumberList.size(); i++){
            Long shareNumber = Long.parseLong(shareNumberList.get(i));
            String shareStatus = shareStatusList.get(i);
            adminService.modifyShareStatus(shareNumber, shareStatus);
        }
        return "변경성공";
    }

    // 신고회원 상태 변경
    @PatchMapping("/updateReport")
    public String modifyReport(@RequestBody Map<String, List<String>> requestBody) {
        List<String> userNumberList = requestBody.get("userNumber");
        List<String> userStatusList = requestBody.get("userStatus");

        for (int i = 0; i < userNumberList.size(); i++) {
            Long userNumber = Long.parseLong(userNumberList.get(i));
            String userStatus = userStatusList.get(i);
            adminService.modifyReportStatus(userNumber, userStatus);
        }
        return "변경성공";
    }


}