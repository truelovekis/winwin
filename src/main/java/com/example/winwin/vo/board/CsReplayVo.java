package com.example.winwin.vo.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CsReplayVo {
   private Long CsNumber;
   private String CsContent;
   private String CsData;
   private Long userNumber;
   private Long csNumber;
   private String userId;
}
