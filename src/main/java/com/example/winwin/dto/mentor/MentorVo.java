package com.example.winwin.dto.mentor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class MentorVo {
    private Long mentorNumber;
    private Long userNumber;
    private Long mpNumber;
    private String mentorStatus;
    private String userName;
    private String userBelong;
    private String careerCompany;
    private String careerTitle;
    private String careerAnnual;
    private String mentorPr;
    private String careerLink;
    private double reviewAvg;
    private List<CareerVo> career;
    private List<SkillVo> skill;
    private List<CareerInfoVo> info;
    private String pfpUploadPath;
    private String pfpSystemName;
    private String pfpUuid;
    private int likeCnt;
    private Long subNumber;
    private String subName;
    private String umStatus;
}
