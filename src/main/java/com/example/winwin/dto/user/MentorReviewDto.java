package com.example.winwin.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MentorReviewDto {
    private Long reviewNumber;
    private String reviewContent;
    private Double reviewStar;
    private Long userNumber;
    private Long mentorNumber;
}
