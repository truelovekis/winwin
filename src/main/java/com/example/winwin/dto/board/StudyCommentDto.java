package com.example.winwin.dto.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class StudyCommentDto {
    private Long commentNumber;
    private String commentContent;
    private String commentDate;
    private Long userNumber;
    private Long studyNumber;
}
