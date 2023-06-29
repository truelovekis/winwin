package com.example.winwin.service.cs;

import com.example.winwin.dto.board.CsDto;
import com.example.winwin.mapper.board.CsMapper;
import com.example.winwin.vo.CsVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CsServiceTest {
    @Mock
    private CsMapper csMapper;
    @InjectMocks
    private CsService csService;

    private CsDto csDto;
    private CsVo csVo;

    @BeforeEach
    void setUp(){
      csDto = new CsDto();
      csDto.setCsContent("test title");
      csDto.setCsContent("test content");
      csDto.setUserNumber(1L);

      csVo = new CsVo();
      csVo.setCsContent("test title");
      csVo.setCsContent("test content");
      csVo.setUserNumber(1L);
      csVo.setUserId("aaa");
    }

    @Test
    @DisplayName("게시물 등록")
    void register() {
        doNothing().when(csMapper).insert(any(CsDto.class));

        csService.register(csDto);

        verify(csMapper, times(1)).insert(csDto);
    }

    @Test
    @DisplayName("게시물 삭제")
    void remote() {
        doNothing().when(csMapper).delete(any(Long.class));

        csService.remove(1L);

        verify(csMapper, times(1)).delete(1L);
    }

    @Test
    @DisplayName("게시물 수정")
    void modify() {
        doNothing().when(csMapper).update(any(CsDto.class));

        csService.modify(csDto);

        verify(csMapper, times(1)).update(csDto);
    }

    @Test
    @DisplayName("게시물 조회")
    void findCs() {
        doReturn(csVo).when(csMapper).select(any(Long.class));

       CsVo foundCs =  csService.findCs(1L);

        assertThat(foundCs).isEqualTo(csVo);
    }

    @Test
    @DisplayName("게시물 조회 : 예외 확인")
    void findCsException() {
        doReturn(null).when(csMapper).select(any(Long.class));


        assertThatThrownBy(() -> {
            csService.findCs(1L);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("존재하지");
    }


    @Test
    @DisplayName("게시물 전체 조회")
    void findAll() {
        doReturn(List.of(csVo)).when(csMapper).selectAll();

        List<CsVo> foundList = csService.findAll();

        assertThat(foundList).contains(csVo);
    }
}