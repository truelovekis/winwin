package com.example.winwin.vo.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class QsBridgeVo {
    private String subName;
    private Long userNumber;
}
