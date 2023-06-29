package com.example.winwin.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminCareerSearchVo {
    private String name;
    private String code;
    private String date;
    private String status;
}
