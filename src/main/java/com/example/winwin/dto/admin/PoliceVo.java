package com.example.winwin.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
public class PoliceVo {
    private String userName;
    private String userId;
    private Long policeNumber;
    private String bigName;
    private Long boardNumber;
    private String categoryName;
    private Long userNumber;
    private String policeDate;
    private String title;
    private String status;
    private String categoryNumber;
    private String bigCode;
}
