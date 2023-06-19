package com.example.winwin.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MentorCareerDto {
    private Long careerNumber;
    private String careerCompany;
    private String careerTitle;
    private String careerStartDate;
    private String careerEndDate;
    private String careerStatus;
    private Long mentorNumber;
}
