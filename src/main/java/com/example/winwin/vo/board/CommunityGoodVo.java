package com.example.winwin.vo.board;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommunityGoodVo {
    private Long userNumber;
    private Long communityNumber;
}
