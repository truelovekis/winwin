package com.example.winwin.mapper.file;

import com.example.winwin.dto.file.CommunityFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityFile {
    public void insert(CommunityFileDto communityFileDto);
    public void delete(Long communityNumber);
    public List<CommunityFileDto> selectList(Long communityNumber);
    public List<CommunityFileDto> selectOldList();
}
