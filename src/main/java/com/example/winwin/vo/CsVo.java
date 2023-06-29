package com.example.winwin.vo;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CsVo {
    private Long csNumber;
    private String csTitle;
    private String csContent;
    private String csDate;
    private Long userNumber;
    private String userId;
    private String userNickname;
    private String userBelong;
}
