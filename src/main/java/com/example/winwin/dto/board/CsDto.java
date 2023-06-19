package com.example.winwin.dto.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CsDto {
    private Long csNumber;
    private String csTitle;
    private String csContent;
    private String csDate;
    private String csStatus;
    private Long userNumber;
}
