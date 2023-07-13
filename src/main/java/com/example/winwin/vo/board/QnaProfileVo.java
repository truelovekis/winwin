package com.example.winwin.vo.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class QnaProfileVo extends QnaVo{

    private String careerCompany;
    private String careerTitle;
    private String pfpSystemName;
    private String pfpUuid;
    private String careerStartDate;
}
