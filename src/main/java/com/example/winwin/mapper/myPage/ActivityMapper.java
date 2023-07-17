package com.example.winwin.mapper.myPage;

import com.example.winwin.vo.infinityScroll.Criteria;
import com.example.winwin.vo.myPage.ActiveBoardVo;
import com.example.winwin.vo.myPage.ActiveCommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
//    전체
    public List<ActiveBoardVo> selectActiveBoardList(Long userNumber, Criteria criteria);
    public List<ActiveCommentVo> selectActiveCommentList(Long userNumber, Criteria criteria);

//    qna
    public int selectTotalQna(Long userNumber);
    public List<ActiveBoardVo> selectActiveQnaBoardList(Long userNumber, Criteria criteria);
    public List<ActiveCommentVo> selectActiveQnaCommentList(Long userNumber, Criteria criteria);

//    커뮤니티
    public int selectTotalCommunity(Long userNumber);
    public List<ActiveBoardVo> selectActiveCommunityBoardList(Long userNumber, Criteria criteria);
    public List<ActiveCommentVo> selectActiveCommunityCommentList(Long userNumber, Criteria criteria);

//    모임
    public int selectTotalMeeting(Long userNumber);
    public List<ActiveBoardVo> selectActiveMeetingBoardList(Long userNumber, Criteria criteria);

//    나눔
    public int selectTotalShare(Long userNumber);
    public List<ActiveBoardVo> selectActiveShareBoardList(Long userNumber, Criteria criteria);

//    문의사항
    public int selectTotalCs(Long userNumber);
    public List<ActiveBoardVo> selectActiveCsBoardList(Long userNumber, Criteria criteria);
}
