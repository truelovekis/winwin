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
    private String boardUuid;
    private String boardUploadPath;
    private String boardSystemName;
    private String boardStatus;
}