package com.example.winwin.service.chatting;

import com.example.winwin.dto.chatting.ChattingDto;
import com.example.winwin.mapper.chatting.ChattingMapper;
import com.example.winwin.vo.myPage.ChattingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChattingService {

    private final ChattingMapper chattingMapper;

    // 쪽지 보내기
    public void sendChatting(ChattingDto chattingDto){
        if(chattingDto == null){throw new IllegalArgumentException("채팅 정보 xxxxxxxxxxx");};
        chattingMapper.sendChatting(chattingDto);
    }

    // 쪽지 조회하기
    public List<ChattingVo> chattingSelect(Long userNumber){
        if(userNumber == null){throw new IllegalArgumentException("존재하지 않는 회원");}

        return Optional.ofNullable(chattingMapper.chattingSelect(userNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하지 않는 회원 번호");});
    }
    
    // 쪽지 모달창 조회하기
    @Transactional(readOnly = true)
    public ChattingVo chattingSelectModal(Long chattingNumber){
        if(chattingNumber == null){throw new IllegalArgumentException("존재하지 않는 쪽지");}
        
        return chattingMapper.chattingSelectModal(chattingNumber);
    }
}
