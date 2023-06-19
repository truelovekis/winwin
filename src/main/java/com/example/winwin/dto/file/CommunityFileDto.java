package com.example.winwin.dto.file;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CommunityFileDto {
    private Long fileNumber;
    private String fileSystemName;
    private String fileUploadPath;
    private String fileUuid;
    private Long communityNumber;
}
