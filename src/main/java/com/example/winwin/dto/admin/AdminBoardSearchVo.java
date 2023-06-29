package com.example.winwin.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminBoardSearchVo {

    private String name;
    private String categoryCode;
    private String communityDate;
    private String status;
}
