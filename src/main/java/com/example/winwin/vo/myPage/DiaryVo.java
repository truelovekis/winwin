package com.example.winwin.vo.myPage;

import com.example.winwin.vo.infinityScroll.Criteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class DiaryVo extends MyPageCriteria {
    private Long userNumber;
    private Long diaryNumber;
    private String diaryTitle;
    private String diaryContent;
    private String diaryDate;
}
