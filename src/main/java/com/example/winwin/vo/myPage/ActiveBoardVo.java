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
public class ActiveBoardVo {
    private int bigCategory;
    private Long boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardDate;
    private int boardCnt;
    private int boardComment;
    private int boardLike;
    private int boardGood;
//  마이페이지 진로정보 추가사항
    private Long userNumber;
    private String userName;
    private String userNickname;
    private Long mentorNumber;
    private String boardSystemName;
    private String boardUploadPath;
    private String boardUuid;
    private int subNumber;
    private String subName;
    private String gradeName;
    private String boardStatus;
}