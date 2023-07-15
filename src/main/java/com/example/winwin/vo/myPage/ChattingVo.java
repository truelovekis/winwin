package com.example.winwin.vo.myPage;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ChattingVo {
    private Long chattingNumber;
    private String chattingContent;
    private String chattingDate;
    private Long chattingTo;
    private Long chattingFrom;
    private String userNickname;
    private String userName;
    private Long userNumber;
    private String pfpUploadPath;
    private String pfpSystemName;
    private String pfpUuid;
}
