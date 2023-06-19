package com.example.winwin.dto.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CareerInfoDto {
    private Long careerInfoNumber;
    private String careerInfoTitle;
    private String careerInfoContent;
    private String careerInfoDate;
    private String careerInfoStatus;
    private int careerInfoCnt;
    private Long userNumber;
}
