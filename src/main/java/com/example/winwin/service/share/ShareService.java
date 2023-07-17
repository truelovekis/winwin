package com.example.winwin.service.share;

import com.example.winwin.dto.share.ShareDto;
import com.example.winwin.mapper.share.ShareMapper;
import com.example.winwin.mapper.user.UserMapper;
import com.example.winwin.mapper.wing.WingMapper;
import com.example.winwin.service.file.ShareFileService;
import com.example.winwin.vo.board.CsProfileVo;
import com.example.winwin.vo.infinityScroll.Criteria;
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
    private final UserMapper userMapper;
    private final WingMapper wingMapper;

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

        shareFileService.shareFileRemove(shareNumber);
        shareMapper.shareDelete(shareNumber);
    }

//    나눔 페이지 무한스크롤
    public List<ShareVo> findListPage(Criteria criteria){
        if(criteria == null){
            throw new IllegalArgumentException("페이지 처리에 필요한 정보가 누락되었습니다.");
        }

        return shareMapper.selectScroll(criteria);
    }

//    나눔 메인페이지 갯수 구하기
    public int findTotal(){

        return shareMapper.selectTotal();
    }

//    로그인 시 유저 프로필 가져오기
    public ShareVo findUserProfile(Long userNumber){
        if (userNumber == null){
            throw new IllegalArgumentException("회원번호가 일치하지 않습니다.");
        }

        return Optional.ofNullable(shareMapper.selectUserProfile(userNumber))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });
    }

    //    나눔 상태 변경 (나눔 완료)
    public void modifyShareStatus(Long shareNumber){
        shareMapper.updateShareStatus(shareNumber);
    }

    // 윙 거래 서비스
    public void wingTrade(int wingAmount, Long fromUserNumber, Long toUserNumber){
//        userMapper.updateUserWing();
//        wingMapper.insertWingLog();

        userMapper.updateUserWing(-wingAmount, fromUserNumber);
        wingMapper.insertWingLog(-wingAmount, fromUserNumber);

        userMapper.updateUserWing(wingAmount, toUserNumber);
        wingMapper.insertWingLog(wingAmount, toUserNumber);
    }

    public ShareVo findLogin(Long userNumber){
        return shareMapper.userLogin(userNumber);
    }
}
