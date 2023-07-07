package com.example.winwin.mapper.chatting;

import com.example.winwin.dto.chatting.ChattingDto;
import com.example.winwin.vo.myPage.ChattingVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChattingMapper {
    // 쪽지 보내기
    public void sendChatting(ChattingDto chattingDto);
    // 쪽지 조회하기
    public List<ChattingVo> chattingSelect(Long userNumber);
    // 쪽지 모달창 조회하기
    public ChattingVo chattingSelectModal(Long chattingNumber);
}
