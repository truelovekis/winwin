package com.example.winwin.vo.myPage;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ActiveCommentVo {
    private int bigCategory;
    private Long boardNumber;
    private String boardTitle;
    private String commentContent;
    private String commentDate;
    private String commentUpDown;
}