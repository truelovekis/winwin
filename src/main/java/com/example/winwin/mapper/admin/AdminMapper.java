package com.example.winwin.mapper.admin;

import com.example.winwin.dto.admin.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminMapper{
    // 전체 회원 조회
    public List<AdminVo> selectTest(AdminVo adminVo);

    // 검색한 회원 조회
    public List<AdminVo> getUserInfo(AdminUserSearchVo adminUserSearchVo);

    // 전체 게시판 조회
    public List<AdminVo> selectBoard();

    // 검색한 게시판 조회
    public List<AdminVo> selectSearchBoard(AdminBoardSearchVo adminBoardSearchVo);

    // 전체 진로 정보 조회
    public List<AdminVo> selectCareer();

    // 검색한 진로 정보 조회
    public List<AdminVo> selectSearchCareer(AdminCareerSearchVo adminCareerSearchVo);

    // 전체 나눔 조회
    public List<AdminVo> selectShare();

    // 검색한 나눔 조회
    public List<AdminVo> selectSearchShare(AdminShareSearchVo adminShareSearchVo);

    // 전체 포인트 조회
    public List<AdminVo> selectWing(AdminVo adminVo);

    // 검색 포인트 조회
    public List<AdminVo> selectSearchWing(AdminWingSearchVo adminWingSearchVo);

    // 전체 신고 조회
    public List<AdminVo> selectReport();

    // 검색한 신고 조회
    public List<AdminVo> selectSearchReport(AdminReportSearchVo adminReportSearchVo);

    // 전체 댓글 신고 조회
    public List<AdminVo> selectReportComment();

    // 검색한 댓글 신고 조회
    public List<AdminVo> selectSearchReportComment(AdminCommentReportSearchVo adminCommentReportSearchVo);

    // 커뮤니티 상태 변경
    public void updateStatus(Long communityNumber, String communityStatus);

    // 진로정보 상태 변경
    public void updateCareer(Long careerInfoNumber, String careerInfoStatus);

    // 나눔 상태 변경
    public void updateShare(Long shareNumber, String shareStatus);

    // 회원 상태 변경
    public void updateUser(Long userNumber, String userStatus);

    // 게시글 신고 상태 변경
    public void updateBoard(Long policeBoard, String boardStatus);

    // 댓글 신고 상태 변경
    public void updateCommentReport(Long policeNumber, String commentStatus);

    // 게시글 진로정보 mainCategory 정보 가져오기
    public List<MainCategoryVo> getCateJob();
    public List<MainCategoryVo> getCateDep();

}
