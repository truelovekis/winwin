package com.example.winwin.vo.infinityScroll;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class PageVo {
    private int pageCount;
    private int startPage;
    private int endPage;
    private int realEnd;
    private int total;
    private Criteria criteria;

    public PageVo(){

    }

    public PageVo(Criteria criteria, int total){
        this(criteria, total, 5);
    }

    public PageVo(Criteria criteria, int total, int pageCount){
        this.criteria = criteria;
        this.total = total;
        this.pageCount = pageCount;

        this.endPage = (int)(Math.ceil(criteria.getPage() / (double)pageCount)) * pageCount;
        this.startPage = endPage - pageCount + 1;

        this.realEnd = (int)(Math.ceil((double)total / criteria.getAmount()));

        if(realEnd < endPage){
            this.endPage = realEnd == 0 ? 1: realEnd;
        }
    }
}
