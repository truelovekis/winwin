package com.example.winwin.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminVo {
    private Long userNumber;
    private String userName;
    private String userId;
    private int mainCode;
    private String userRrnumber;
    private String userPhonenumber;
    private String userEmail;
    private String mentorStatus;
    private String mainName;
    private String categoryName;
    private Long communityNumber;
    private String communityTitle;
    private String communityDate;
    private String communityStatus;
    private int categoryNumber;
    private int userWing;
    private String wingEarnDate;
    private String subName;
    private Long careerInfoNumber;
    private String careerInfoTitle;
    private String careerInfoDate;
    private String careerInfoStatus;
    private String subNumber;
    private String policeDate;
    private String bigName;
    private String userStatus;
    private String policeCategoryName;
    private Long shareNumber;
    private String shareTitle;
    private String shareContent;
    private String shareDate;
    private String shareStatus;
    private String commentDate;
    private String commentStatus;
    private Long policeNumber;
    private String boardStatus;
    private Long policeBoard;
    private String userPosition;
    private String status;

}
