package com.example.winwin.dto.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResumeDto {
    private Long resumeNumber;
    private String resumeTitle;
    private String resumeName;
    private String resumeAddress;
    private String resumeEmail;
    private String resumeWebsite;
    private String resumeSchool1;
    private String schoolStartDate1;
    private String schoolEndDate1;
    private String resumeSchool2;
    private String schoolStartDate2;
    private String schoolEndDate2;
    private String resumeCareer1;
    private String careerStartDate1;
    private String careerEndDate1;
    private String resumeCareer2;
    private String careerStartDate2;
    private String careerEndDate2;
    private String resumeCareer3;
    private String careerStartDate3;
    private String careerEndDate3;
    private String resumeCertiName1;
    private String resumeCertiGrade1;
    private String resumeCertiNoto1;
    private String resumeCertiName2;
    private String resumeCertiGrade2;
    private String resumeCertiNoto2;
    private String resumeCertiName3;
    private String resumeCertiGrade3;
    private String resumeCertiNoto3;
    private String resumeCertiName4;
    private String resumeCertiGrade4;
    private String resumeCertiNoto4;
    private String resumeCertiName5;
    private String resumeCertiGrade5;
    private String resumeCertiNoto5;
    private Long userNumber;

    public ResumeDto(){
        resumeSchool2 = "";
        schoolStartDate2 = "";
        schoolEndDate2 = "";
        resumeCareer2 = "";
        careerStartDate2 = "";
        careerEndDate2 = "";
        resumeCareer3 = "";
        careerStartDate3 = "";
        careerEndDate3 = "";
        resumeCertiName2 = "";
        resumeCertiGrade2 = "";
        resumeCertiNoto2 = "";
        resumeCertiName3 = "";
        resumeCertiGrade3 = "";
        resumeCertiNoto3 = "";
        resumeCertiName4 = "";
        resumeCertiGrade4 = "";
        resumeCertiNoto4 = "";
        resumeCertiName5 = "";
        resumeCertiGrade5 = "";
        resumeCertiNoto5 = "";
    }
}
