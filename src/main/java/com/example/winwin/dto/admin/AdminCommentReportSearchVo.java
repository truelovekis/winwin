package com.example.winwin.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminCommentReportSearchVo {
    private String name;
    private String bigCode;
    private Long code;
    private String status;

}
