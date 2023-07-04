package com.example.winwin.vo.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CategoryBridgeVo {
    private Long bridgeNumber;
    private int subNumber;
    private Long userNumber;
}
