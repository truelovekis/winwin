package com.example.winwin.vo.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StudyVo {
    private Long studyNumber;
    private String studyTitle;
    private String studyContent;
    private String studySummaryTitle;
    private String studySummaryContent;
    private String studyRole;
    private String studyStatus;
    private String studyOpenlink;
    private String studyDate;
    private Long userNumber;
    private String userNickname;
    private Long categoryNumber;
    private Long purposeNumber;
    private String purposeName;
    private Long timeNumber;
    private Long studyReadCnt;
    private int likeCnt;
    private String isNew;
}
