package com.example.winwin.dto.mentor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CategoryVo {
    private String mainCode;
    private Long mainNumber;
    private String mainName;
    private String subName;
    private int subNumber;
    private int certificationNumber;
}
