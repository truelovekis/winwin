package com.example.winwin.dto.mentor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class CareerInfoVo {
    private Long careerInfoNumber;
    private String careerInfoTitle;
    private String careerInfoContent;
    private String careerInfoDate;
    private String careerInfoStatus;
    private Long careerInfoCnt;
    private int careerInfoLike;
    private Long mentorNumber;
    private Long userNumber;
    private String userName;
    private String userNickname;
    private String pfpSystemname;
    private String pfpUploadPath;
    private String pfpUuid;
    private String userBelong;
    private String careerAnnual;
    private int subNumber;
    private String subName;
    private String gradeName;
    private List<Integer> tagList;
}
