package com.example.winwin.service.board;

import com.example.winwin.dto.board.CommunityDto;
import com.example.winwin.mapper.board.CommunityMapper;
import com.example.winwin.service.file.CommunityFileService;
import com.example.winwin.vo.board.CommunityVo;
import com.example.winwin.vo.board.CommunityProfileVo;
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
public class CommunityService {
    private final CommunityMapper communityMapper;
    private final CommunityFileService communityFileService;
    private final CommunityCommentService communityCommentService;

    public void register(CommunityDto communityDto){
        if (communityDto == null) {
            throw new IllegalArgumentException("게시판 정보가 없습니다.");
        }
        communityMapper.insert(communityDto);
    }

    public void remove(Long communityNumber){
        if (communityNumber == null){
            throw new IllegalArgumentException("게시물 번호 누락");
        }
        communityFileService.remove(communityNumber);
        communityCommentService.deleteCommunity(communityNumber);
        communityMapper.delete(communityNumber);
    }

    public void modify(CommunityDto communityDto, List<MultipartFile> files) throws IOException{
        communityFileService.remove(communityDto.getCommunityNumber());
        communityFileService.registerAndSaveFiles(files, communityDto.getCommunityNumber());
        communityMapper.update(communityDto);
    }

    public void modify(CommunityDto communityDto ){
        if( communityDto == null){
            throw new IllegalArgumentException("게시물 수정 정보 누락");
        }
        communityMapper.update(communityDto);
    }

    public int upHitCnt(Long communityNumber) {
        if(communityNumber == null){
            throw new IllegalArgumentException("게시물 번호 누락");
        }
        return communityMapper.upHit(communityNumber);
    }

    public int commentCnt(Long communityNumber){
        if(communityNumber == null){
            throw new IllegalArgumentException("댓글 번호 누락");
        }
        return communityMapper.commentCnt(communityNumber);
    }

    @Transactional(readOnly = true)
    public CommunityVo find(Long communityNumber){
        if(communityNumber == null){
            throw new IllegalArgumentException("게시물 번호 누락");
        }
        return Optional.ofNullable(communityMapper.select(communityNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("존재하지 않는 게시물 번호"); });
    }

    @Transactional(readOnly = true)
    public List<CommunityVo> findAll(CommunityVo communityVo){
        return communityMapper.selectAll(communityVo);
    }

    public List<CommunityProfileVo> registerProfile(Long userNumber){
        return communityMapper.selectUserProfile(userNumber);
    }


}
