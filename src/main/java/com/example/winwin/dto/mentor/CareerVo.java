package com.example.winwin.dto.mentor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CareerVo {
    private Long careerNumber;
    private String careerCompany;
    private String careerTitle;
    private String careerStartDate;
    private String careerEndDate;
    private String careerStatus;
    private String careerAnnual;
    private Long mentorNumber;
    private String careerInfoContent;
    private String careerInfoTitle;
    private String careerInfoCnt;
    private String careerLink;
}
