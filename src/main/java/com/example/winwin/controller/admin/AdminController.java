package com.example.winwin.controller.admin;

import com.example.winwin.dto.admin.*;
import com.example.winwin.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {

    private final AdminService adminService;


    @GetMapping("/user")
    // 전체 회원 조회
    public String adminUser(AdminVo adminVo, Model model){
        List<AdminVo> adminVoList = adminService.findTest(adminVo);
        model.addAttribute("adminVoList", adminVoList);
        return "admin/adminUser";
    }
    // 검색한 회원 조회
    @GetMapping("/result")
    public String search(AdminUserSearchVo adminUserSearchVo, Model model){
        List<AdminVo> adminVoList = adminService.findUserInfo(adminUserSearchVo);
        model.addAttribute("adminVoList", adminVoList);

        return "admin/adminUser";
    }


    // 전체 게시판 조회
    @GetMapping("/board")
    public String adminBoard(Model model){
        List<AdminVo> adminList = adminService.findBoard();
        model.addAttribute("adminList", adminList);
        return "admin/adminBoard";
    }
    // 검색한 게시판 조회
    @GetMapping("/searchBoard")
    public String adminBoardSearch(AdminBoardSearchVo adminBoardSearchVo, Model model){
        System.out.println("adminBoardSearchVo");
        System.out.println(adminBoardSearchVo);
        List<AdminVo> adminList = adminService.findSearchBoard(adminBoardSearchVo);
        model.addAttribute("adminList", adminList);
        return "admin/adminBoard";
    }


    // 전체 진로 정보 조회
    @GetMapping("/jobBoard")
    public String adminJobBoard(Model model){
        List<AdminVo> adminCareerList = adminService.findCareer();
        model.addAttribute("adminCareerList", adminCareerList);
        return "admin/adminJobBoard";
    }

    // 검색한 진로 정보 조회
    @GetMapping("/searchCareer")
    public String adminCareerSearch(AdminCareerSearchVo adminCareerSearchVo, Model model){
        List<AdminVo> adminCareerList = adminService.findSearchCareer(adminCareerSearchVo);
        model.addAttribute("adminCareerList", adminCareerList);
        return "admin/adminJobBoard";
    }

    // 전체 나눔 조회
    @GetMapping("/share")
    public String adminShare(Model model){
        List<AdminVo> adminShareList = adminService.findShare();
        model.addAttribute("adminShareList", adminShareList);

        return "admin/adminShare";
    }

    // 검색한 나눔 조회
    @GetMapping("/searchShare")
    public String adminShareSearch(AdminShareSearchVo adminShareSearchVo, Model model){
        List<AdminVo> adminShareList = adminService.findSearchShare(adminShareSearchVo);
        model.addAttribute("adminShareList", adminShareList);
        return "admin/adminShare";
    }


    // 전체 윙 조회
    @GetMapping("/point")
    public String adminPoint(AdminVo adminVo, Model model){
        List<AdminVo> adminPointList = adminService.findWing(adminVo);
        model.addAttribute("adminPointList", adminPointList);
        return "admin/adminPoint";
    }
    // 검색한 윙 조회
    @GetMapping("/searchWing")
    public String adminWingSearch(AdminWingSearchVo adminWingSearchVo, Model model){
        List<AdminVo> adminPointList = adminService.findSearchWing(adminWingSearchVo);
        model.addAttribute("adminPointList", adminPointList);
        return "admin/adminPoint";
    }


    // 전체 신고 조회
    @GetMapping("/report")
    public String adminReport(Model model){
        List<AdminVo> adminReportList = adminService.findReport();
        model.addAttribute("adminReportList", adminReportList);
        return "admin/adminReport";
    }
    // 검색한 신고 조회
    @GetMapping("/searchReport")
    public String adminReportSearch(AdminReportSearchVo adminReportSearchVo, Model model){
        List<AdminVo> adminReportList = adminService.findSearchReport(adminReportSearchVo);
        model.addAttribute("adminReportList", adminReportList);
        return "admin/adminReport";
    }



    // 데이터 가져오기
    @PostMapping("/mainCategory")
    public String adminMainCategory(Model model){
        List<MainCategoryVo> mainCategoryList = adminService.findMainCategory();
        System.out.println("mainCategoryList");
        System.out.println(mainCategoryList);
        model.addAttribute("mainCategoryList", mainCategoryList);
        return "admin/adminJobBoard";
    }

}
