package com.example.winwin.service.share;

import com.example.winwin.dto.share.ShareDto;
import com.example.winwin.mapper.share.ShareMapper;
import com.example.winwin.service.file.ShareFileService;
import com.example.winwin.vo.share.ShareVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ShareService {

    private final ShareMapper shareMapper;
    private final ShareFileService shareFileService;

//    나눔 글 등록하기
    public void shareRegister(ShareDto shareDto){
        if(shareDto == null){
            throw new IllegalArgumentException("나눔 글 정보가 누락되었습니다.");
        }

        shareMapper.shareInsert(shareDto);
    }

//    나눔 글 번호로 조회하기
    @Transactional(readOnly = true)
    public ShareVo findShare(Long shareNumber){
        if(shareNumber == null){
            throw new IllegalArgumentException("나눔 글 번호가 일치하지 않습니다.");
        }

        return Optional.ofNullable(shareMapper.shareSelectNumber(shareNumber))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 나눔 글 입니다.");
                });
    }

//    나늠 글 전체 최신순 조회하기
    @Transactional(readOnly = true)
    public List<ShareVo> shareFindAll(){
        return shareMapper.shareSelectAll();
    }

//    나눔 글 상세보기 진입 시 조회 수 증가
    public void shareReadUpdate(Long shareNumber){
        if(shareNumber == null){
            throw new IllegalArgumentException("게시글 번호가 일치하지 않습니다.");
        }

        shareMapper.shareReadCnt(shareNumber);
    }

//    나눔 글 번호로 수정하기
    public void shareModify(ShareDto shareDto, List<MultipartFile> files)throws IOException {
        shareFileService.shareFileRemove(shareDto.getShareNumber());
        shareFileService.registerAndSaveFiles(files, shareDto.getShareNumber());
        shareMapper.shareUpdate(shareDto);
    }

//    나눔 글 번호로 삭제하기
    public void shareRemove(Long shareNumber){
        if(shareNumber == null){
            throw new IllegalArgumentException("나눔 글 번호가 일치하지 않습니다.");
        }
//        수정사항 : 나눔 글 삭제 시 share_file 삭제 참고 - BK_sniper
        
        shareMapper.shareDelete(shareNumber);
    }

}
