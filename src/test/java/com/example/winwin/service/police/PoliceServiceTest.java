package com.example.winwin.service.police;

import com.example.winwin.dto.police.PoliceBoardDto;
import com.example.winwin.mapper.police.PoliceBoardMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Transactional
class PoliceServiceTest {

    @Mock
    private PoliceBoardMapper policeBoardMapper;

    @InjectMocks
    private PoliceService policeService;
    private PoliceBoardDto policeBoardDto;

    @BeforeEach
    void setUp(){
        policeBoardDto = new PoliceBoardDto();
        policeBoardDto.setBigCode("600");
        policeBoardDto.setBoardNumber(149L);
        policeBoardDto.setPoliceCategory(4L);
        policeBoardDto.setUserNumber(8L);
    }

    @Test
    @DisplayName("나눔 신고하기 단위 테스트")
    void policeBoardRegister() {
        doNothing().when(policeBoardMapper).shareReportInsert(any(PoliceBoardDto.class));

        policeBoardMapper.shareReportInsert(policeBoardDto);

        verify(policeBoardMapper, times(1)).shareReportInsert(policeBoardDto);

    }

    @Test
    @DisplayName("게시글 번호로 신고항목 조회하기 단위 테스트")
    void findBoard(){
        doReturn(policeBoardDto).when(policeBoardMapper).shareReportSelect(any(Long.class));

        PoliceBoardDto foundBoard = policeService.findBoard(1L);

        assertThat(foundBoard).isEqualTo(policeBoardDto);
    }

    @Test
    @DisplayName("게시글 번호로 신고항목 조회하기 예외 확인 단위 테스트")
    void findBoardException(){
        doReturn(null).when(policeBoardMapper).shareReportSelect(any(Long.class));

        assertThatThrownBy(()->{
            policeService.findBoard(1L);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지");
    }

    @Test
    @DisplayName("게시글 번호로 신고항목 삭제하기 단위 테스트")
    void policeBoardRemove(){
        doNothing().when(policeBoardMapper).shareReportDelete(any(Long.class));

        policeService.policeBoardRemove(1L);

        verify(policeBoardMapper, times(1)).shareReportDelete(1L);
    }
}