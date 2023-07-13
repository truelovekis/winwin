package com.example.winwin.vo.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CsReplyVo {
   private Long commentNumber;
   private String commentContent;
   private String commentDate;
   private Long userNumber;
   private Long csNumber;
   private String userId;
}
