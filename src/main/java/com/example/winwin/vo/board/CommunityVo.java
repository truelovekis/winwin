package com.example.winwin.vo.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CommunityVo {
    private Long communityNumber;
    private String categoryName;  // 추가함
    private String userNickname;  // 추가함
    private String userBelong; // 추가함
    private String communityTitle;
    private String communityContent;
    private String communityDate;
    private int communityCnt;
    private Long categoryNumber;
    private Long userNumber;
    private String userId;
    private String fileSystemName;
    private String fileUploadPath;
    private String fileUuid;
    private String categoryTypeStr;
}
