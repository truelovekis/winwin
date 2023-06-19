package com.example.winwin.dto.chatting;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ChattingDto {
    private Long chattingNumber;
    private String chattingContent;
    private String chattingDate;
    private Long userNumber;
    private Long mentorNumber;
}
