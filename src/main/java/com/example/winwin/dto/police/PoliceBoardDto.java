package com.example.winwin.dto.police;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PoliceBoardDto {
    private Long policeNumber;
    private String bigCode;
    private Long boardNumber;
    private Long policeCategory;
    private Long userNumber;
    private String policeDate;
}
