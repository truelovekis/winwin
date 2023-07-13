package com.example.winwin.vo.myPage;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class DiaryVo {
    private Long userNumber;
    private Long diaryNumber;
    private String diaryTitle;
    private String diaryContent;
    private String diaryDate;
}
