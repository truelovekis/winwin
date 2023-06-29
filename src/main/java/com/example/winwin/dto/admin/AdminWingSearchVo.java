package com.example.winwin.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminWingSearchVo {
    private String name;
    private String id;
    private String date;
    private String mentor;
}
