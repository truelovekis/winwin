package com.example.winwin.dto.police;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PoliceCommentDto {
    private Long policeNumber;
    private String bigCode;
    private Long commentNumber;
    private Long policeCategory;
    private Long userNumber;
}
