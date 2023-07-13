package com.example.winwin.mapper.chatting;

import com.example.winwin.dto.chatting.ChattingDto;
import com.example.winwin.vo.myPage.ChattingVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChattingMapper {
    // 쪽지 보내기
    public void sendChatting(ChattingDto chattingDto);
    // 쪽지 조회하기 (받은 쪽지)
    public List<ChattingVo> chattingSelect(Long userNumber);
    // 쪽지 조회하기 (보낸 쪽지)
    public List<ChattingVo> chattingSelectFrom(Long userNumber);
    // 쪽지 모달창 조회하기 (받은 쪽지)
    public ChattingVo chattingSelectModal(Long chattingNumber);
    // 쪽지 모달창 조회하기 (보낸 쪽지)
    public ChattingVo chattingSendModal(Long chattingNumber);
    // 답장하기 (회원이름, 닉네임 뽑아오기)
    public ChattingVo selectChattingName(Long chattingNumber);
}
