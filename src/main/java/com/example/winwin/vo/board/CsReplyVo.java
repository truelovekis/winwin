package com.example.winwin.vo.board;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CsReplayVo {
   private Long replayNumber;
   private String replayContent;
   private String replayDate;
   private Long  userNumber;
   private Long csNumber;
   private String userId;
}
