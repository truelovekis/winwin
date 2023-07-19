package com.example.winwin.vo.myPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class MyPageCriteria {
    private int page;
    private int amount;

    public MyPageCriteria(){
        this(1, 9);
    }
}
