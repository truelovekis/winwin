package com.example.winwin.dto.careerInfo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CareerInfoCommentVo {
    private Long commentNumber;
    private String commentContent;
    private String commentDate;
    private Long careerInfoNumber;
    private Long userNumber;
    private String userNickname;
    private String pfpSystemName;
    private String pfpUploadPath;
    private String pfpUuid;
}
