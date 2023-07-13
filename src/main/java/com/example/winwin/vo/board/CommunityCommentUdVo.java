package com.example.winwin.vo.board;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommunityCommentUdVo {
    private Long userNumber;
    private Long commentNumber;
    private String udStatus;
    private int udCnt;
}
