package com.example.winwin.vo.share;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ShareVo {
    private Long shareNumber;
    private String shareTitle;
    private String shareContent;
    private String shareDate;
    private int shareWing;
    private String shareStatus;
    private int shareReadCnt;
    private Long userNumber;
    private String userId;
    private String fileSystemName;
    private String fileUploadPath;
    private String fileUuid;
}
