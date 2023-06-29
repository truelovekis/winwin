package com.example.winwin.vo.myPage;

import com.example.winwin.vo.user.UserVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Data
@NoArgsConstructor
public class MyPageVo {
    private UserVo userVo;
    private List<String> mentorTag;
    private List<Map<Integer, String>> interestTag;
    private int boardCnt;
    private int commentCnt;
}
