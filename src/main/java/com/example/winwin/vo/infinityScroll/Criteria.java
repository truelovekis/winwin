package com.example.winwin.vo.infinityScroll;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class Criteria {
    private int page;
    private int amount;

    public Criteria() {
        this(1, 10);
    }
}
