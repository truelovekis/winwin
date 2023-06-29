package com.example.winwin.mapper.file;

import org.apache.ibatis.annotations.Mapper;

import com.example.winwin.dto.file.ShareFileDto;

import java.util.List;

@Mapper
public interface ShareFileMapper {

    //    나눔 파일 등록하기
    void shareFileInsert(ShareFileDto shareFileDto);

    //    나눔 글 번호로 파일 조회하기
    List<ShareFileDto> shareFileList(Long shareNumber);

    //    나눔 글 번호로 파일 삭제하기
    void shareFileDelete(Long shareNumber);

    //    나눔 글 전날 파일 업로드 된 것 조회하기
    List<ShareFileDto> shareOldSelect();
}
