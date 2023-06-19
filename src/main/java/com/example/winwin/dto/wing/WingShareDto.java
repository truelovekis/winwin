package com.example.winwin.dto.wing;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class WingShareDto {
    private Long wingShareNumber;
    private Long userNumber;
}
