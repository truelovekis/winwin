package com.example.winwin.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ResumeDto {
    private Long resumeNumber;
    private String resumeTitle;
    private String resumeName;
    private String resumeAddress;
    private String resumeEmail;
    private String resumeWebsite;
    private String resumeSchool;
    private String resumeStartDate;
    private String resumeEndDate;
    private String resumeCertiName;
    private String resumeCertiGrade;
    private String resumeUserImg;
    private Long userNumber;
}
