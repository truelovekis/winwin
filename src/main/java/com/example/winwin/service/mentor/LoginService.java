package com.example.winwin.service.mentor;

import com.example.winwin.dto.mentor.LoginVo;
import com.example.winwin.mapper.mentor.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginMapper loginMapper;

    public Long findMentorNumber(String userId, String userPassword){
        if (userId == null || userPassword == null) {
            throw new IllegalArgumentException("회원 정보 누락");
        }
        return Optional.ofNullable(loginMapper.loginMentor(userId, userPassword)).orElseThrow(() -> {
            throw new IllegalArgumentException("존재하지 않는 회원 번호");
        });
    }

    public String findUser(Long userNumber){
        if (userNumber == null) {
            throw new IllegalArgumentException("정보 누락");
        }
        return loginMapper.loginUser(userNumber);
    }
}
