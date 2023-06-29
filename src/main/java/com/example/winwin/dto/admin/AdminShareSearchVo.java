package com.example.winwin.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminShareSearchVo {
    private String name;
    private String title;
    private String shareDate;
    private String status;
}
