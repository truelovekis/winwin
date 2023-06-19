package com.example.winwin.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class DiaryDto {
    private Long diaryNumber;
    private String diaryTitle;
    private String diaryContent;
    private String diaryDate;
    private Long userNumber;
}
