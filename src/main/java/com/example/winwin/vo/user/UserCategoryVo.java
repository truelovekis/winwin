package com.example.winwin.vo.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserCategoryVo {
    private String mainCode;
    private String mainName;
    private int subNumber;
    private String subName;
}
