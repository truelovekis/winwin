package com.example.winwin.vo.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class QnaCommentVo {
    private Long commentNumber;
    private String commentContent;
    private String commentDate;
    private Long userNumber;
    private Long qnaNumber;
    private String userId;
//    private String userBelong;
    private String udStatus;
    private int udCnt;
    private Long sessionUserNumber;
}
