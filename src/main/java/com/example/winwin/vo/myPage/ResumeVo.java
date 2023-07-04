package com.example.winwin.vo.myPage;

import com.example.winwin.dto.user.ResumeDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ResumeVo {
    private ResumeDto resumeDto;
    private String userPhoneNumber;
}
