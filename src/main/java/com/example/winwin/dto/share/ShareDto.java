package com.example.winwin.dto.share;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ShareDto {
    private Long shareNumber;
    private String shareTitle;
    private String shareContent;
    private String shareDate;
    private int shareWing;
    private String shareStatus;
    private int shareReadCent;
    private Long userNumber;
}
