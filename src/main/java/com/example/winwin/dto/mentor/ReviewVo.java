package com.example.winwin.dto.mentor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReviewVo {
    private Long reviewNumber;
    private Long mentorNumber;
    private String reviewContent;
    private double reviewStar;
    private Long userNumber;
    private String userNickName;
}
