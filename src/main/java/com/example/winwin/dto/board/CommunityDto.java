package com.example.winwin.dto.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CommunityDto {
    private Long communityNumber;
    private String communityTitle;
    private String communityContent;
    private String communityDate;
    private int communityCnt;
    private Long categoryNumber;
    private Long userNumber;
}
