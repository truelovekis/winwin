package com.example.winwin.service.cs;


import com.example.winwin.dto.board.CsCommentDto;
import com.example.winwin.mapper.board.CsCommentMapper;
import com.example.winwin.vo.board.CsReplyVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CsReplayService {
    private final CsCommentMapper csCommentMapper;

    public void register(CsCommentDto csCommentDto) {
        if (csCommentDto == null) {
            throw new IllegalArgumentException("댓글 정보 누락");
        }
        csCommentMapper.insert(csCommentDto);
    }

    @Transactional(readOnly = true)
    public List<CsReplyVo> findList(Long csNumber) {
        if (csNumber == null) {
            throw new IllegalArgumentException("댓글 번호 누락");
        }

        return csCommentMapper.selectList(csNumber);
    }

    @Transactional(readOnly = true)

    public CsReplyVo findComment(Long commentNumber) {
        if (commentNumber == null) {
            throw new IllegalArgumentException("댓글 번호 누락");
        }
        return Optional.ofNullable(csCommentMapper.select(commentNumber))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 댓글 번호"); });
    }

    public void modify(CsCommentDto csCommentDto) {
        if (csCommentDto == null) {
            throw new IllegalArgumentException("댓글 수정 정보 누락");
        }
        csCommentMapper.update(csCommentDto);
    }

    public void remove(Long commentNumber) {
        if (commentNumber == null) {
            throw new IllegalArgumentException("댓글 번호 누락");
        }
        csCommentMapper.delete(commentNumber);
    }

    public void deleteReply(Long commentNumber){
        if(commentNumber == null){
            throw new IllegalArgumentException ("게시글 번호 누락");
        }
        csCommentMapper.deleteReplay(commentNumber);
    }
}

