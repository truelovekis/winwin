package com.example.winwin.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ResumePrDto {
    private Long prNumber;
    private String prBigTitle;
    private String prSmallTitle;
        private String prContent1;
    private String prContent2;
    private String prContent3;
    private Long userNumber;
}
