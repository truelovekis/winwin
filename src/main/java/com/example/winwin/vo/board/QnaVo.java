package com.example.winwin.vo.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class QnaVo {

    private int commentCnt;
    private int qnaLikeCnt;
    private Long qnaNumber;
    private String qnaTitle;
    private String qnaContent;
    private String qnaDate;
    private int qnaCnt;
    private Long userNumber;
    private String subName;
    private Long subNumber;
    private String userBelong;
    private String userNickname;
    private String userIdentity;
    private String userId;
}
