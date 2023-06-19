package com.example.winwin.dto.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class QnaDto {
    private Long qnaNumber;
    private String qnaTitle;
    private String qnaContent;
    private String qnaDate;
    private int qnaCnt;
    private Long userNumber;
}
