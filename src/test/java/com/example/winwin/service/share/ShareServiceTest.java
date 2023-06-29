package com.example.winwin.service.share;

import com.example.winwin.dto.share.ShareDto;
import com.example.winwin.mapper.share.ShareMapper;
import com.example.winwin.vo.share.ShareVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Transactional
class ShareServiceTest {

    @Mock
    private ShareMapper shareMapper;

    @InjectMocks
    private ShareService shareService;
    private ShareDto shareDto;
    private ShareVo shareVo;

    @BeforeEach
    void setUp(){
        shareDto = new ShareDto();
        shareDto.setShareTitle("title");
        shareDto.setShareContent("content");
        shareDto.setShareWing(300);
        shareDto.setShareStatus("1");
        shareDto.setUserNumber(1L);
    }

    @Test
    @DisplayName("나눔 글 등록하기 단위 테스트")
    void shareRegister() {
        doNothing().when(shareMapper).shareInsert(any(ShareDto.class));

        shareMapper.shareInsert(shareDto);

        verify(shareMapper, times(1)).shareInsert(shareDto);
    }

    @Test
    @DisplayName("나눔 글 번호로 조회하기 단위 테스트")
    void findShare() {
        doReturn(shareDto).when(shareMapper).shareSelectNumber(any(Long.class));

        ShareVo foundShare = shareService.findShare(1L);

        assertThat(foundShare).isEqualTo(shareDto);
    }

    @Test
    @DisplayName("나눔 글 번호로 조회하기 예외 확인 단위 테스트")
    void findShareException() {
        doReturn(null).when(shareMapper).shareSelectNumber(any(Long.class));

        assertThatThrownBy(()->{
            shareService.findShare(1L);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지");
    }

    @Test
    @DisplayName("나눔 글 전체 최신순 조회하기 단위 테스트")
    void shareFindAll() {
        doReturn(List.of(shareDto)).when(shareMapper).shareSelectAll();

        List<ShareVo> shareDtoList = shareService.shareFindAll();

//        assertThat(shareDtoList).contains(shareDto);
    }

    @Test
    @DisplayName("나눔 글 번호로 수정하기 단위 테스트")
    void shareModify() {
        doNothing().when(shareMapper).shareUpdate(any(ShareDto.class));

//        shareService.shareModify(shareDto);

        verify(shareMapper, times(1)).shareUpdate(shareDto);
    }

    @Test
    @DisplayName("나눔 글 번호로 삭제하기 단위테스트")
    void shareRemove() {
        doNothing().when(shareMapper).shareDelete(any(Long.class));

        shareService.shareRemove(1L);

        verify(shareMapper, times(1)).shareDelete(1L);
    }
}