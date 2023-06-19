package com.example.winwin.dto.wing;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class WingDto {
    private Long wingNumber;
    private int wingEarnAmount;
    private String wingEarnDate;
    private Long userNumber;
}
