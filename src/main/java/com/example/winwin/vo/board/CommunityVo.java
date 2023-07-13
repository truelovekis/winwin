package com.example.winwin.vo.board;

import com.example.winwin.vo.infinityScroll.Criteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CommunityVo extends Criteria{
    private Long communityNumber;
    private String categoryName;  // 추가함
    private String userNickname;  // 추가함
    private String userBelong; // 추가함
    private String userIdentity; // 추가함
    private String communityTitle;
    private String communityContent;
    private String communityDate;
    private int communityCnt;
    private int commentCnt;
    private int likeCnt; // 좋아요 추가함
    private Long categoryNumber;
    private Long userNumber;
    private String userId;
    private String fileSystemName;
    private String fileUploadPath;
    private String fileUuid;
    private String categoryTypeStr;
    private String userStatus; // 추가함
    private String communityStatus; // 추가함
}
