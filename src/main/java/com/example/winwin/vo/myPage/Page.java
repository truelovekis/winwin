package com.example.winwin.vo.myPage;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Page {
    //    페이지 세트당 표시 될 수
    private int pageCount;
    //    페이지 세트의 시작 숫자
    private int startPage;
    //    페이지 세트의 마지막 숫자
    private int endPage;
    //    실제 마지막 페이지
    private int realEnd;
    //    이전 버튼 표시 여부
    private boolean prev;
    //    다음 버튼 표시 여부
    private boolean next;
    //    전체 게시글 수
    private int total;
    //    화면에서 전달 받은 page, amount를 저장하는 객체
    private MyPageCriteria myPageCriteria;

    public Page() {  }

    public Page(MyPageCriteria myPageCriteria, int total){
        this(myPageCriteria, total, 5);
    }

    public Page(MyPageCriteria myPageCriteria, int total, int pageCount){
        this.myPageCriteria = myPageCriteria;
        this.total = total;
        this.pageCount = pageCount;

//        현제 페이지를 기준으로 세트의 마지막 번호, 시작 번호를 구한다.
        this.endPage = (int)(Math.ceil(myPageCriteria.getPage() / (double)pageCount)) * pageCount;
        this.startPage = endPage - pageCount + 1;

//        게시글 전체 개수로 실제 마지막 페이지를 구한다.
        this.realEnd = (int) (Math.ceil((double) total / myPageCriteria.getAmount()));

//        세트의 마지막 번호보다 실제 마지막 페이지가 작다면?
        if(realEnd < endPage){
//            세트의 마지막 번호를 실제 마지막 페이지로 교체한다.
            this.endPage = realEnd == 0 ? 1 : realEnd;
        }

//        this.prev = startPage > 1;
//        this.next = endPage < realEnd;
    }
}
