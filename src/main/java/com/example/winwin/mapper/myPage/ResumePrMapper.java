package com.example.winwin.mapper.myPage;

import com.example.winwin.dto.user.ResumePrDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResumePrMapper {
    public void insertPr(ResumePrDto resumePrDto);
    public List<ResumePrDto> selectPrList(Long userNumber);
    public ResumePrDto selectPr(Long prNumber);
}
