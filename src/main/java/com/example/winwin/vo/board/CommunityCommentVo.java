package com.example.winwin.vo.board;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommunityCommentVo {
    private Long commentNumber;
    private String commentContent;
    private String commentDate;
    private Long userNumber;
    private Long communityNumber;
    private String userId;
    private String userBelong;
}
