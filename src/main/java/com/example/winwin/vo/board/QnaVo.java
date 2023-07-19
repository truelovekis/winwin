package com.example.winwin.vo.board;

import com.example.winwin.vo.infinityScroll.Criteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Data
@NoArgsConstructor
public class QnaVo extends Criteria {

    private int commentCnt;
    private int qnaLikeCnt;
    private Long qnaNumber;
    private String qnaTitle;
    private String qnaContent;
    private String qnaDate;
    private int qnaCnt;
    private Long userNumber;
    private String subName;
    private Long subNumber;
    private String userBelong;
    private String userNickname;
    private String userIdentity;
    private String userId;
    private String subNames;
    private List<String> subNameList;
    private String gradeName; // 프로필 추가
    private String userPosition; // 프로필 추가
    private int cnt;
    private Long mentorNumber;

    public void makeSubList(){
        this.subNameList = Arrays.stream(subNames.split(",")).collect(Collectors.toList());
    }

    public void setSubNames(String subNames){
        this.subNames = subNames;
        makeSubList();
    }
}
