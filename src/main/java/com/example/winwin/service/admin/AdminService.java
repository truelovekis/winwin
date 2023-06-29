package com.example.winwin.service.admin;

import com.example.winwin.dto.admin.*;
import com.example.winwin.mapper.admin.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {
    private final AdminMapper adminMapper;

    // 전체 회원 조회
    public List<AdminVo> findTest(AdminVo adminVo) {
        return adminMapper.selectTest(adminVo);
    }

    public List<AdminVo> findUserInfo(AdminUserSearchVo adminUserSearchVo) {
        return adminMapper.getUserInfo(adminUserSearchVo);
    }

    // 전체 게시판 조회
    public List<AdminVo> findBoard() {
        return adminMapper.selectBoard();
    }

    // 검색한 게시판 조회
    public List<AdminVo> findSearchBoard(AdminBoardSearchVo adminBoardSearchVo) {
        System.out.println(adminBoardSearchVo);
        return adminMapper.selectSearchBoard(adminBoardSearchVo);
    }

    // 전체 진로 정보 조회
    public List<AdminVo> findCareer() {
        return adminMapper.selectCareer();
    }

    // 검색한 진로 정보 조회
    public List<AdminVo> findSearchCareer(AdminCareerSearchVo adminCareerSearchVo) {
        return adminMapper.selectSearchCareer(adminCareerSearchVo);
    }

    // 전체 나눔 조회
    public List<AdminVo> findShare(){
        return adminMapper.selectShare();
    }

    // 검색한 나눔 조회
    public List<AdminVo> findSearchShare(AdminShareSearchVo adminShareSearchVo){
        return adminMapper.selectSearchShare(adminShareSearchVo );
    }

    // 전체 포인트 조회
    public List<AdminVo> findWing(AdminVo adminVo) {
        return adminMapper.selectWing(adminVo);
    }

    // 검색한 포인트 조회
    public List<AdminVo> findSearchWing(AdminWingSearchVo adminWingSearchVo) {
        return adminMapper.selectSearchWing(adminWingSearchVo);
    }

    // 전체 신고 조회하기
    public List<AdminVo> findReport() {
        return adminMapper.selectReport();
    }

    // 검색한 신고 조회하기
    public List<AdminVo> findSearchReport(AdminReportSearchVo adminReportSearchVo) {
        return adminMapper.selectSearchReport(adminReportSearchVo);
    }

    // 게시글 진로정보 subCategory 정보 가져오기
    public List<MainCategoryVo> findMainCategory() {

        return adminMapper.getMainCategory();
    }

    // 커뮤니티 상태 변경
    public void modifyBoardStatus(Long communityNumber, String communityStatus) {
        if (communityNumber == null || communityStatus == null) {
            throw new IllegalArgumentException("커뮤니티 수정 정보 누락");
        }

        adminMapper.updateStatus(communityNumber, communityStatus);
    }

    // 진로정보 상태 변경
    public void modifyCareerStatus(Long careerInfoNumber, String careerInfoStatus){
        if(careerInfoNumber == null || careerInfoStatus == null){
            throw new IllegalArgumentException("진로정보 수정 정보 누락");
        }
        adminMapper.updateCareer(careerInfoNumber, careerInfoStatus);
    }

    // 나눔 상태 변경
    public void modifyShareStatus(Long shareNumber, String shareStatus){
        if (shareNumber == null || shareStatus == null){
            throw new IllegalArgumentException("나눔 수정 정보 누락");
        }
        adminMapper.updateShare(shareNumber, shareStatus);
    }

    // 신고회원 상태 변경
    public void modifyReportStatus(Long userNumber, String userStatus){
        if (userNumber == null || userStatus == null ){
            throw new IllegalArgumentException("신고회원 수정 정보 누락");
        }
        adminMapper.updateReport(userNumber, userStatus);
    }

}
