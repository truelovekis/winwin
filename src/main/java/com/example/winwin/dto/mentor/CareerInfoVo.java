package com.example.winwin.dto.mentor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

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
    private String userName;
    private String userBelong;
    private String careerTitle;
    private String careerAnnual;

}
