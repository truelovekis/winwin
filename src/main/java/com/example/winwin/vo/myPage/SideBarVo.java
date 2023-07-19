package com.example.winwin.vo.myPage;

import com.example.winwin.dto.user.UserPfpDto;
import com.example.winwin.vo.user.UserVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Data
@NoArgsConstructor
public class SideBarVo {
    // 사이드바에 쓸 닉네임과 멘토/멘티와 등급명과 프로필 사진 가져오기
    private String userNickname;
    private String userPosition;
    private String gradeName;
    private UserPfpDto userPfpDto;
}
