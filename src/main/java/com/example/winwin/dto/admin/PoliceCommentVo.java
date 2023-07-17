package com.example.winwin.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PoliceCommentVo {
//    POLICE_NUMBER, BC.BIG_NAME, COMMENT_NUMBER, PC.CATEGORY_NAME, J1. USER_NUMBER,
//    TO_CHAR(COMMENT_DATE,'YYYY-MM-DD') AS COMMENT_DATE,
//    CONTENT, STATUS,
//    U.USER_NAME, U.USER_ID

    private Long policeNumber;
    private String bigName;
    private Long commentNumber;
    private String categoryName;
    private Long userNumber;
    private String commentDate;
    private String userName;
    private String userId;
    private String content;
    private String status;
    private String categoryNumber;
    private String bigCode;
    private String communityCommentStatus;


}
