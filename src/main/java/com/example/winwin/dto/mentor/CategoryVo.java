package com.example.winwin.dto.mentor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CategoryVo {
    private String mainCode;
    private String mainName;
    private String subName;
    private Long mainNumber;
    private Long subNumber;
}
