package com.example.winwin.vo.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class QnaCommentUdVo {
    private Long userNumber;
    private Long commentNumber;
    private String udStatus;
    private int udCnt;
}
