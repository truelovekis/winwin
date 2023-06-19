package com.example.winwin.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserPfpDto {
    private Long pfpNumber;
    private String pfpUploadPath;
    private String pfpSystemName;
    private String pfpUuid;
    private Long userNumber;
}
